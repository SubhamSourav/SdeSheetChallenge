import java.util.*;

public class _6kruskal {

    public static void union(int u, int v, int[] parent, int[] rank) {
        if (rank[u] > rank[v])
            parent[v] = parent[u];
        else if (u < v)
            parent[u] = parent[v];
        else {
            parent[v] = parent[u];
            rank[u]++;
        }
    }

    public static int findParent(int node, int[] parent) {
        if (node == parent[node])
            return node;
        return parent[node] = findParent(parent[node], parent);
    }

    public static int kruskalMST(int n, int m, ArrayList<ArrayList<Integer>> graph) {
        Collections.sort(graph, (a, b) -> a.get(2) - b.get(2));
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        int c = 0, res = 0;
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (ArrayList<Integer> edge : graph) {
            int u = findParent(edge.get(0), parent);
            int v = findParent(edge.get(1), parent);
            int w = edge.get(2);
            if (u != v) {
                union(u, v, parent, rank);
                res += w;
                c++;
                if (c == n - 1)
                    break;
            }
        }

        return res;
    }

}