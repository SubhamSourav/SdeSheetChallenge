import java.util.ArrayList;

public class _1maxSubProd {
    public static int maximumProduct(ArrayList<Integer> arr, int n) {
        int ma = arr.get(0);
        int mi = ma, ans = ma;

        for (int i = 1; i < n; i++) {
            if (arr.get(i) < 0) {
                int temp = ma;
                ma = mi;
                mi = temp;
            }
            ma = Math.max(arr.get(i), arr.get(i) * ma);
            mi = Math.min(arr.get(i), arr.get(i) * mi);
            ans = Math.max(ans, ma);
        }
        return ans;
    }
}