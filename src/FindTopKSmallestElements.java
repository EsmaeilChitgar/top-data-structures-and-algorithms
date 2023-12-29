import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindTopKSmallestElements {
    public static void main(String[] args) {
        FindTopKSmallestElements findTopKSmallestElements = new FindTopKSmallestElements();

        int[] array = new int[]{1, 8, 7, 9, 5, 98, 80, 65, 3};
        int k = 3;
        System.out.println(Arrays.toString(findTopKSmallestElements.find(array, k)));
    }

    private int[] find(int[] array, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            maxHeap.offer(array[i]);
        }

        for (int i = k; i < array.length; i++) {
            if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }


        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[k - i - 1] = maxHeap.poll();
        }

        return result;
    }
}
