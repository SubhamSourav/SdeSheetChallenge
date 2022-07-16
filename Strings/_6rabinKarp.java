import java.util.ArrayList;

public class _6rabinKarp {
    static int prime = 101;

    static int getHash(String s) {
        int n = s.length(), hash = 0;

        for (int i = 0; i < n; i++) {
            hash += s.charAt(i) * Math.pow(prime, i);
        }
        return hash;
    }

    static int reHash(int oldHash, int newc, int oldc, int m) {
        oldHash -= oldc;
        oldHash /= prime;
        oldHash += newc * Math.pow(prime, m - 1);
        return oldHash;
    }

    public static ArrayList<Integer> stringMatch(String str, String pat) {
        int n = str.length(), m = pat.length();
        ArrayList<Integer> ans = new ArrayList<>();
        int p = getHash(pat);
        int s = getHash(str.substring(0, m));

        if (p == s && pat.equals(str.substring(0, m)))
            ans.add(0);

        for (int i = 1; i <= n - m; i++) {
            s = reHash(s, str.charAt(i + m - 1), str.charAt(i - 1), m);
            if (s == p && pat.equals(str.substring(i, i + m))) {
                ans.add(i);
            }
        }

        return ans;

    }
}