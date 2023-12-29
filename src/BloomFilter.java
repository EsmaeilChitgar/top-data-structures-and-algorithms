import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.function.Function;

public class BloomFilter {
    private final int size;
    private final List<Function<String, Integer>> hashFunctions;

    private final BitSet bitSet;

    public BloomFilter(int size, List<Function<String, Integer>> hashFunctions) {
        this.size = size;
        this.hashFunctions = hashFunctions;
        this.bitSet = new BitSet(size);
        bitSet.set(0, size - 1, false);
    }

    public void add(String value) {
        for (Function<String, Integer> hf : hashFunctions) {
            int index = hf.apply(value) % size;
            bitSet.set(index);
        }
    }

    public boolean contains(String value) {
        for (var hf : hashFunctions) {
            int index = hf.apply(value) % size;
            if (!bitSet.get(index)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<Function<String, Integer>> hFunctions = new ArrayList<>();
        hFunctions.add(String::length);
        hFunctions.add(s -> Math.abs(s.hashCode()));

        BloomFilter bloomFilter = new BloomFilter(10, hFunctions);

        bloomFilter.add("apple");
        bloomFilter.add("orange");

        System.out.println(bloomFilter.contains("apple"));   // true (possibly in the set)
        System.out.println(bloomFilter.contains("banana"));  // false (definitely not in the set)
    }
}