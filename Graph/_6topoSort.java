import java.util.*;

public class _6topoSort {
    static void dfs(List<List<Integer>> adj, Stack<Integer> st, boolean[] vis, int node) {
        vis[node] = true;

        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfs(adj, st, vis, it);
            }
        }

        st.push(node);
    }

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }

        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(adj, st, vis, i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }

        return ans;
    }
}
