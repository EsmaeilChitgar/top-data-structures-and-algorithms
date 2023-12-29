import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // to store the smaller half
    private PriorityQueue<Integer> minHeap; // to store the larger half

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // max heap
        minHeap = new PriorityQueue<>(); // min heap
    }

    public void addNumber(int num) {
        // Add the number to the appropriate heap
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Balance the heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        // If total elements are even, return the average of the middle two
        if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            // If total elements are odd, return the middle element
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNumber(1);
        System.out.println("Median: " + medianFinder.findMedian()); // Output: 1.0

        medianFinder.addNumber(2);
        System.out.println("Median: " + medianFinder.findMedian()); // Output: 1.5

        medianFinder.addNumber(3);
        System.out.println("Median: " + medianFinder.findMedian()); // Output: 2.0
    }
}
