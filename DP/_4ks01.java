import java.util.*;

public class _4ks01 {

    static int func(ArrayList<Integer> values, ArrayList<Integer> weights, int i, int w, int[][] dp) {
        if (i == 0) {
            if (weights.get(0) <= w)
                return values.get(0);
            else
                return 0;
        }
        if (dp[i][w] != -1)
            return dp[i][w];

        int x = 0 + func(values, weights, i - 1, w, dp);
        int y = Integer.MIN_VALUE;
        if (weights.get(i) <= w) {
            y = values.get(i) + func(values, weights, i - 1, w - weights.get(i), dp);
        }
        return dp[i][w] = Math.max(x, y);
    }

    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int[][] dp = new int[n][w + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return func(values, weights, n - 1, w, dp);
    }
}