import java.util.*;

public class _5ratInAMaze {

    static int[] di = { 1, 0, 0, -1 };
    static int[] dj = { 0, -1, 1, 0 };

    static void getPath(int[][] maze, ArrayList<ArrayList<Integer>> ans, int[][] path, int i, int j, int n) {
        if (i == -1 || j == -1 || i == n || j == n || maze[i][j] == 0)
            return;
        if (i == n - 1 && j == n - 1) {
            path[i][j] = 1;
            ArrayList<Integer> temp = new ArrayList<>();
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    temp.add(path[a][b]);
                }
            }
            ans.add(new ArrayList<>(temp));
            return;
        }

        path[i][j] = 1;
        maze[i][j] = 0;
        for (int x = 0; x < 4; x++) {
            getPath(maze, ans, path, i + di[x], j + dj[x], n);
        }
        path[i][j] = 0;
        maze[i][j] = 1;
    }

    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[][] path = new int[n][n];
        getPath(maze, ans, path, 0, 0, n);
        return ans;
    }
}
