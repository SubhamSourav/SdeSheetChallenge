import java.util.*;

public class _3kthLarStream {
    PriorityQueue<Integer> maxpq;
    PriorityQueue<Integer> minpq;
    int k;

    _3kthLarStream(int k, int[] arr) {
        maxpq = new PriorityQueue<>((a, b) -> b - a);
        minpq = new PriorityQueue<>();
        this.k = k;

        for (int i = 0; i < arr.length; i++) {
            minpq.add(arr[i]);
            if (minpq.size() > k)
                maxpq.add(minpq.remove());
        }

    }

    void add(int num) {
        minpq.add(num);
        if (minpq.size() > k)
            maxpq.add(minpq.remove());
    }

    int getKthLargest() {
        return minpq.peek();
    }
}
