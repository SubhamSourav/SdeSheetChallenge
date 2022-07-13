import java.util.*;

public class Solution {

    public static int[] KMostFrequent(int n, int k, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) {
            int c = map.containsKey(ele) ? map.get(ele) : 0;
            map.put(ele, c + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> map.get(a) - map.get(b));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry.getKey());
            if (pq.size() > k)
                pq.poll();
        }

        int[] ans = new int[k];
        int p = 0;
        while (!pq.isEmpty()) {
            ans[p++] = pq.poll();
        }
        return ans;
    }

}
