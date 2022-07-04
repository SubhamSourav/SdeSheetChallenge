import java.util.ArrayList;
import java.util.Arrays;

public class _3Sum {
    public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            int diff = K - arr[i];
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (arr[j] + arr[k] < diff) {
                    j++;
                } else if (arr[j] + arr[k] > diff) {
                    k--;
                } else {
                    ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k])));
                    while (j < k && arr[j] == arr[j + 1])
                        j++;
                    j++;
                    while (j < K && arr[k] == arr[k - 1])
                        k--;
                    k--;
                }
            }
            while (i < n - 2 && arr[i] == arr[i + 1])
                i++;
        }
        return ans;
    }
}
