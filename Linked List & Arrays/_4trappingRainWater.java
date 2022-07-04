public class _4trappingRainWater {
    public static long getTrappedWater(long[] arr, int n) {
        if (n <= 2)
            return 0;

        int l = 0, r = n - 1;
        long maxl = 0, maxr = 0, ans = 0;

        while (l <= r) {
            if (arr[l] <= arr[r]) {
                if (arr[l] < maxl)
                    ans += maxl - arr[l];
                else
                    maxl = Math.max(arr[l], maxl);
                l++;
            } else {
                if (arr[r] < maxr)
                    ans += maxr - arr[r];
                else
                    maxr = Math.max(arr[r], maxr);
                r--;
            }
        }
        return ans;
    }
}
