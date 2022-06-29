public class _5gridUniquePaths {
    static int function(int i, int j, int m, int n, int[][] dp) {
        if (i == m - 1 && j == n - 1)
            return 1;
        if (i == m || j == n)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        return dp[i][j] = function(i + 1, j, m, n, dp) + function(i, j + 1, m, n, dp);
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return function(0, 0, m, n, dp);
    }
}
