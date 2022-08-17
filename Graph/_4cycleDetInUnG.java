import java.util.*;

class Pair {
    int first, second;

    Pair(int a, int b) {
        first = a;
        second = b;
    }
}

public class _4cycleDetInUnG {

    static boolean check(List<List<Integer>> adj, boolean[] vis, int s, int n) {
        vis[s] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(s, -1));

        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            for (int ele : adj.get(node)) {
                if (!vis[ele]) {
                    vis[ele] = true;
                    q.add(new Pair(ele, node));
                } else if (parent != ele) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String cycleDetection(int[][] edges, int n, int m) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] vis = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                if (check(adj, vis, i, n))
                    return "Yes";
            }
        }

        return "No";
    }

}