import java.util.*;

public class _5kthLar {
    static int kthLargest(ArrayList<Integer> arr, int size, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            pq.add(arr.get(i));
            if (pq.size() > K)
                pq.remove();
        }
        return pq.peek();
    }
}
