public class _12compVerNo {
    public static int compareVersions(String a, String b) {
        int l1 = a.length(), l2 = b.length(), i = 0, j = 0;
        Long t1, t2;

        while (i < l1 || j < l2) {
            t1 = 0l;
            t2 = 0l;
            while (i < l1 && a.charAt(i) != '.') {
                t1 = t1 * 10 + a.charAt(i) - '0';
                i++;
            }

            while (j < l2 && b.charAt(j) != '.') {
                t2 = t2 * 10 + b.charAt(j) - '0';
                j++;
            }

            if (t1 > t2)
                return 1;
            else if (t2 > t1)
                return -1;
            else {
                i++;
                j++;
            }
        }

        return 0;
    }
}