import java.util.*;

public class _4floydWarshell {
    static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        int[][] dist = new int[n + 1][n + 1];

        for (int[] row : dist) {
            Arrays.fill(row, (int) 1e9);
        }

        for (ArrayList<Integer> edge : edges) {
            dist[edge.get(0)][edge.get(1)] = edge.get(2);
        }

        for (int i = 1; i <= n; i++) {
            dist[i][i] = 0;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] == 1e9 || dist[k][j] == 1e9)
                        continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        return dist[src][dest];
    }

}
