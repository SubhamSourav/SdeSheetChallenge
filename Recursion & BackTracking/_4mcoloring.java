import java.util.*;

public class _4mcoloring {

    static boolean check(List<List<Integer>> adj, int v, int n, int m, int[] color) {
        if (v == n)
            return true;

        for (int i = 1; i <= m; i++) {
            boolean valid = true;

            for (int node : adj.get(v)) {
                if (color[node] == i)
                    valid = false;
            }

            if (valid) {
                color[v] = i;
                if (check(adj, v + 1, n, m, color))
                    return true;
                color[v] = 0;
            }
        }

        return false;

    }

    public static String graphColoring(int[][] mat, int m) {
        int n = mat.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        int[] color = new int[n];
        if (check(adj, 0, n, m, color))
            return "YES";
        return "NO";
    }
}
