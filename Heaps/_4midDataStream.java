
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static void findMedian(int arr[]) {

        if (arr.length == 0)
            return;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        System.out.print(arr[0] + " ");
        maxHeap.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (maxHeap.peek() >= arr[i]) {
                maxHeap.add(arr[i]);
            } else {
                minHeap.add(arr[i]);
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            if (i % 2 == 0) {
                System.out.print(maxHeap.peek() + " ");
            } else {
                System.out.print(((maxHeap.peek() + minHeap.peek()) / 2) + " ");
            }
        }

    }

}