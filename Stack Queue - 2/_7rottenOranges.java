import java.util.*;

public class _7rottenOranges {

    public static int minTimeToRot(int[][] grid, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        int oranges = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2)
                    q.add(new int[] { i, j });
                if (grid[i][j] != 0)
                    oranges++;
            }
        }

        if (oranges == 0)
            return 0;
        int sec = 0, c = 0;
        int dx[] = { -1, 0, 1, 0 };
        int dy[] = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int size = q.size();
            c += size;
            for (int i = 0; i < size; i++) {
                int[] block = q.remove();
                for (int j = 0; j < 4; j++) {
                    int x = block[0] + dx[j];
                    int y = block[1] + dy[j];

                    if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;
                    grid[x][y] = 2;
                    q.add(new int[] { x, y });
                }
            }
            if (q.size() != 0)
                sec++;
        }

        return oranges == c ? sec : -1;
    }

}
