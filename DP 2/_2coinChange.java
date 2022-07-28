import java.util.*;

public class _2coinChange {

    public static long countWaysToMakeChange(int denominations[], int value) {
        long[] dp = new long[value + 1];
        dp[0] = 1;
        Arrays.sort(denominations);
        for (int i = 0; i < denominations.length; i++) {
            for (int j = denominations[i]; j < dp.length; j++) {
                dp[j] += dp[j - denominations[i]];
            }
        }
        return dp[value];
    }

}