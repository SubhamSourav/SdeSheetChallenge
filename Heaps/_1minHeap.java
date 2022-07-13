import java.util.*;

public class Solution {

    // minHeap function which take size of Queries and Queries as Input.
    // Returns an array out outputs depending on the query.
    static int[] minHeap(int n, int[][] q) {
        ArrayList<Integer> ans = new ArrayList();
        int c = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (q[i][0] == 0) {
                pq.add(q[i][1]);
            } else {
                if (!pq.isEmpty()) {
                    ans.add(pq.poll());
                }
            }
        }

        return ans.stream().mapToInt(j -> j).toArray();
    }
}