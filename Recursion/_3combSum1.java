import java.util.ArrayList;

public class _3combSum1 {
    static void subset(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> set, int k,
            int i) {

        if (i == arr.size()) {
            if (k == 0) {
                ans.add(new ArrayList<>(set));
            }
            return;
        }

        set.add(arr.get(i));
        subset(arr, ans, set, k - arr.get(i), i + 1);
        set.remove(set.size() - 1);
        subset(arr, ans, set, k, i + 1);
    }

    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        subset(arr, ans, new ArrayList<>(), k, 0);
        return ans;
    }
}
