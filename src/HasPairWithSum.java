import java.util.HashSet;
import java.util.Set;

public class HasPairWithSum {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5};
        int sum = 8;
        Set<Integer> set = new HashSet<>();

        for (int a : array) {
            if (set.contains(a)) {
                System.out.println("found");
                break;
            } else {
                set.add(sum - a);
            }
        }

        System.out.println("not found");
    }
}