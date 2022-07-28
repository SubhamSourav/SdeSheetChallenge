import java.util.ArrayList;

public class _6MSIS {
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {

        int[] dp = new int[n];
        dp[0] = rack.get(0);
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            for (int pi = i - 1; pi >= 0; pi--) {
                if (rack.get(pi) < rack.get(i)) {
                    dp[i] = Math.max(dp[i], dp[pi]);
                }
            }
            dp[i] = dp[i] + rack.get(i);
            max = Math.max(dp[i], max);
        }

        return max;

    }
}