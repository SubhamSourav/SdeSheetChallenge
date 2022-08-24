import java.util.*;

public class _5powerSet {
    public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
        int n = arr.size();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int no = 0; no < (1 << n); no++) {
            ArrayList<Integer> sub = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((1 << i & no) != 0) {
                    sub.add(arr.get(i));
                }
            }
            ans.add(sub);
        }
        return ans;
    }
}
