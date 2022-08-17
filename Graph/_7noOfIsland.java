import java.util.*;

class Pair {
    int i, j;

    Pair(int _i, int _j) {
        i = _i;
        j = _j;
    }
}

public class _7noOfIsland {
    static void bfs(int[][] mat, boolean[][] vis, int i, int j, int n, int m) {
        Queue<Pair> q = new LinkedList<>();
        vis[i][j] = true;
        q.add(new Pair(i, j));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            for (int ith = -1; ith <= 1; ith++) {
                for (int jth = -1; jth <= 1; jth++) {
                    int row = p.i + ith;
                    int col = p.j + jth;
                    if (row >= 0 && col >= 0 && row < n && col < m && mat[row][col] == 1 && !vis[row][col]) {
                        vis[row][col] = true;
                        q.add(new Pair(row, col));
                    }
                }
            }
        }
    }

    public static int getTotalIslands(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && !vis[i][j]) {
                    c++;
                    bfs(mat, vis, i, j, n, m);
                }
            }
        }

        return c++;
    }
}