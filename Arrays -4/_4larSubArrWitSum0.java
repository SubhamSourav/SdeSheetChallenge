import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class _4larSubArrWitSum0 {
    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

        int max = 0, s = 0;
        Map<Integer, Integer> sumidx = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            s += arr.get(i);
            if (s == 0) {
                max = i + 1;
            } else {
                if (!sumidx.containsKey(s)) {
                    sumidx.put(s, i);
                } else {
                    max = Math.max(max, i - sumidx.get(s));
                }
            }
        }
        return max;
    }
}
