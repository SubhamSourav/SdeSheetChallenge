import java.util.*;

public class _1minPathSum {

    static int find(int[][] grid, int i, int j, int[][] dp) {
        if (i == 0 && j == 0)
            return grid[0][0];
        if (i < 0 || j < 0)
            return (int) Math.pow(10, 9);
        if (dp[i][j] != -1)
            return dp[i][j];
        int x = grid[i][j] + find(grid, i - 1, j, dp);
        int y = grid[i][j] + find(grid, i, j - 1, dp);

        return dp[i][j] = Math.min(x, y);
    }

    public static int minSumPath(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return find(grid, grid.length - 1, grid[0].length - 1, dp);
    }
}