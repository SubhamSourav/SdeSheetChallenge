import java.util.*;

class pair {
    int li, di, val;

    pair(int li, int di, int val) {
        this.li = li;
        this.di = di;
        this.val = val;
    }
}

public class Solution {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            pair p = new pair(i, 0, kArrays.get(i).get(0));
            pq.add(p);
        }

        while (pq.size() > 0) {
            pair p = pq.poll();
            ans.add(p.val);
            p.di++;
            if (p.di < kArrays.get(p.li).size()) {
                p.val = kArrays.get(p.li).get(p.di);
                pq.add(p);
            }
        }

        return ans;
    }
}
