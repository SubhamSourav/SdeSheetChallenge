import java.util.*;

public class _5cycleDetInDG {

    static boolean dfs(List<List<Integer>> adj, boolean[] vis, boolean[] dfsvis, int node) {
        vis[node] = true;
        dfsvis[node] = true;

        for (int ele : adj.get(node)) {
            if (dfsvis[ele] || dfs(adj, vis, dfsvis, ele))
                return true;
        }

        dfsvis[node] = false;
        return false;
    }

    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.size(); i++) {
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }

        boolean[] vis = new boolean[n + 1];
        boolean[] dfsvis = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                if (dfs(adj, vis, dfsvis, i))
                    return true;
            }
        }

        return false;
    }
}