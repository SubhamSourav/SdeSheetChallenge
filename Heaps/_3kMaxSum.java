import java.util.*;

public class Solution {
    public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pq.size() < k)
                    pq.add(a.get(i) + b.get(j));
                else {
                    if (a.get(i) + b.get(j) > pq.peek()) {
                        pq.poll();
                        pq.add(a.get(i) + b.get(j));
                    }
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty())
            ans.add(0, pq.poll());

        return ans;
    }
}