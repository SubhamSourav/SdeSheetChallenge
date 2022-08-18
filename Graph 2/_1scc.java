import java.util.*;

public class _1scc {

    static void dfs(List<List<Integer>> adj, Stack<Integer> st, boolean[] vis, int node) {
        vis[node] = true;
        for (int ele : adj.get(node)) {
            if (!vis[ele])
                dfs(adj, st, vis, ele);
        }
        st.push(node);
    }

    static void revdfs(List<List<Integer>> tp, boolean[] vis, int node, List<Integer> temp) {
        vis[node] = true;
        temp.add(node);
        for (int it : tp.get(node)) {
            if (!vis[it])
                revdfs(tp, vis, it, temp);
        }
    }

    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> tp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            tp.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            tp.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i])
                dfs(adj, st, vis, i);
        }

        Arrays.fill(vis, false);

        while (!st.isEmpty()) {
            int node = st.pop();
            if (!vis[node]) {
                List<Integer> temp = new ArrayList<>();
                revdfs(tp, vis, node, temp);
                ans.add(temp);
            }
        }

        return ans;

    }
}