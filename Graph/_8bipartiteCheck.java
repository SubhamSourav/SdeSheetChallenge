import java.util.*;

public class _8bipartiteCheck {

    static boolean bfs(List<List<Integer>> adj, int[] color, int node) {
        Queue<Integer> q = new LinkedList();
        q.add(node);
        color[node] = 1;

        while (!q.isEmpty()) {
            int ele = q.poll();
            for (int it : adj.get(ele)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[ele];
                    q.add(it);
                } else if (color[it] == color[ele])
                    return false;
            }
        }

        return true;
    }

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {

        int v = edges.size();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (edges.get(i).get(j) == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int[] color = new int[v];
        Arrays.fill(color, -1);

        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                if (!bfs(adj, color, i))
                    return false;
            }
        }

        return true;
    }
}