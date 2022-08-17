public class _4rodCutting {
    public static int cutRod(int price[], int n) {
        int[] np = new int[n + 1];
        for (int i = 0; i < n; i++) {
            np[i + 1] = price[i];
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = np[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = np[i];
            int li = 1;
            int ri = i - 1;
            while (li <= ri) {
                dp[i] = Math.max(dp[i], dp[li] + dp[ri]);
                li++;
                ri--;
            }
        }
        return dp[n];
    }
}