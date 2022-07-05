import java.util.ArrayList;
import java.util.Arrays;

public class _2subset2 {
    static void subset(int[] arr, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> set, int idx) {
        ans.add(new ArrayList<>(set));
        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1])
                continue;
            set.add(arr[i]);
            subset(arr, ans, set, i + 1);
            set.remove(set.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        subset(arr, ans, new ArrayList<>(), 0);
        return ans;
    }
}
