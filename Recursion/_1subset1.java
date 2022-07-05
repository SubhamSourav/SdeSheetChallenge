import java.util.ArrayList;
import java.util.Collections;

public class _1subset1 {
    static void sum(int num[], ArrayList<Integer> ans, int sum, int i) {
        if (i == num.length) {
            ans.add(sum);
            return;
        }
        sum(num, ans, sum + num[i], i + 1);
        sum(num, ans, sum, i + 1);
    }

    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        sum(num, ans, 0, 0);
        Collections.sort(ans);
        return ans;
    }
}