public class _7palPart {

    public static int palindromePartitioning(String str) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; j++, i++) {
                if (g == 0)
                    dp[i][j] = true;
                else if (g == 1)
                    dp[i][j] = str.charAt(i) == str.charAt(j);
                else {
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1])
                        dp[i][j] = true;
                    else
                        dp[i][j] = false;
                }
            }
        }

        int[] strg = new int[n];
        strg[0] = 0;

        for (int j = 1; j < n; j++) {
            if (dp[0][j])
                strg[j] = 0;
            else {
                int min = Integer.MAX_VALUE;
                for (int i = j; i >= 1; i--) {
                    if (dp[i][j]) {
                        min = Math.min(min, strg[i - 1]);
                    }
                }
                strg[j] = min + 1;
            }
        }

        return strg[n - 1];
    }
}
