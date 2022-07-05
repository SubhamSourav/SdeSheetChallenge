import java.util.ArrayList;
import java.util.Collections;

public class _4combSum2 {
    static void subset(ArrayList<Integer> arr, int target, int idx, ArrayList<ArrayList<Integer>> ans,
            ArrayList<Integer> set) {

        if (target == 0) {
            ans.add(new ArrayList<>(set));
            return;
        }

        for (int i = idx; i < arr.size(); i++) {
            if (i > idx && arr.get(i) == arr.get(i - 1))
                continue;
            if (arr.get(i) > target)
                break;
            set.add(arr.get(i));
            subset(arr, target - arr.get(i), i + 1, ans, set);
            set.remove(set.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target) {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        subset(arr, target, 0, ans, new ArrayList<Integer>());
        return ans;
    }
}
