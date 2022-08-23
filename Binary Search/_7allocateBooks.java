public class _7allocateBooks {
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        long low = 0, high = 0;

        for (int ele : time) {
            low = Math.max(low, ele);
            high += ele;
        }

        while (low < high) {
            long mid = (low + high) / 2;

            int c = 1;
            long sum = 0;
            for (int ele : time) {
                if (ele + sum > mid) {
                    sum = ele;
                    c++;
                } else
                    sum += ele;
            }

            if (c > n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}