import java.util.*;

public class _2medInStream {
    public static int[] findMedian(int[] arr, int n) {
        PriorityQueue<Integer> maxpq = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        int[] med = new int[n];

        med[0] = arr[0];
        maxpq.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] >= maxpq.peek()) {
                minpq.add(arr[i]);
            } else {
                maxpq.add(arr[i]);
            }

            if (maxpq.size() > minpq.size() + 1) {
                minpq.add(maxpq.remove());
            } else if (maxpq.size() < minpq.size()) {
                maxpq.add(minpq.remove());
            }

            med[i] = i % 2 == 0 ? maxpq.peek() : (maxpq.peek() + minpq.peek()) / 2;
        }

        return med;
    }
}
