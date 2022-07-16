public class _2lonPalSubStr {

    static int expandAroundCentre(String str, int n, int l, int r) {

        while (l >= 0 && r < n && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static String longestPalinSubstring(String str) {
        int n = str.length(), start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            int len1 = expandAroundCentre(str, n, i, i);
            int len2 = expandAroundCentre(str, n, i, i + 1);
            int len = Math.max(len1, len2);
            if (len - 1 > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return str.substring(start, end + 1);
    }
}
