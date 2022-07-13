public class Solution {
    public static double median(int[] a, int[] b) {
        if (a.length > b.length)
            return median(b, a);

        int n = a.length, m = b.length, low = 0, high = a.length;

        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            double l1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            double l2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];
            double r1 = cut1 == n ? Integer.MAX_VALUE : a[cut1];
            double r2 = cut2 == m ? Integer.MAX_VALUE : b[cut2];

            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }

        }

        return 0.0;
    }
}