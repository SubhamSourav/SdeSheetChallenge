public class _7zAlgo {

    static int[] getZ(StringBuilder sb) {
        int n = sb.length(), left = 0, right = 0;
        int[] z = new int[n];

        for (int i = 0; i < n; i++) {
            if (right < i) {
                left = right = i;
                while (right < n && sb.charAt(right) == sb.charAt(right - left))
                    right++;
                z[i] = right - left;
                right--;
            } else {
                int k = i - left;
                if (z[k] < right - i + 1)
                    z[i] = z[k];
                else {
                    left = i;
                    while (right < n && sb.charAt(right) == sb.charAt(right - left))
                        right++;
                    z[i] = right - left;
                    right--;
                }
            }
        }

        return z;

    }

    public static int zAlgorithm(String s, String p, int n, int m) {

        StringBuilder sb = new StringBuilder();
        sb.append(p);
        sb.append('$');
        sb.append(s);

        int z[] = getZ(sb);
        int ans = 0;

        for (int i = 0; i < z.length; i++) {
            if (z[i] == m)
                ans++;
        }
        // System.out.println(Arrays.toString(z));
        return ans;

    }

}