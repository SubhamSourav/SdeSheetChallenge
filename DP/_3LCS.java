
public class _3LCS {

    public static int lcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] lcs = new int[n][m];

        if (s.charAt(0) == t.charAt(0)) {
            lcs[0][0] = 1;
        }

        for (int j = 1; j < m; j++) {
            lcs[0][j] = s.charAt(0) == t.charAt(j) ? 1 + lcs[0][j - 1] : lcs[0][j - 1];
        }

        for (int i = 1; i < n; i++) {
            lcs[i][0] = s.charAt(i) == t.charAt(0) ? 1 + lcs[i - 1][0] : lcs[i - 1][0];
            for (int j = 1; j < m; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                }
            }
        }
        return lcs[n - 1][m - 1];
    }

}