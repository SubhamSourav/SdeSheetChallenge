public class _3subsetSum {

    public static boolean subsetSumToK(int n, int k, int arr[]) {
        boolean[][] dp = new boolean[n + 1][k + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = false;
                else if (j == 0)
                    dp[i][j] = true;
                else {
                    if (dp[i - 1][j])
                        dp[i][j] = true;
                    else {
                        int val = arr[i - 1];
                        if (j >= val) {
                            dp[i][j] = dp[i - 1][j - val];
                        }
                    }
                }
            }
        }
        return dp[n][k];
    }
}
