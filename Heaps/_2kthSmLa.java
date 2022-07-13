import java.util.*;

public class Solution {
    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
        PriorityQueue<Integer> maxpq = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minpq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            maxpq.add(arr.get(i));
            minpq.add(arr.get(i));
        }

        int r = k - 1;

        while (r > 0) {
            maxpq.remove();
            minpq.remove();
            r--;
        }

        return new ArrayList<>(Arrays.asList(minpq.peek(), maxpq.peek()));
    }
}
