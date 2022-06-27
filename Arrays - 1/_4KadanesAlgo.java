public class _4KadanesAlgo {
    public static long maxSubarraySum(int[] arr, int n) {

        long max = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
        }
        return max;
    }

}