import java.util.*;

public class _1sum2 {
    public static int[][] pairSum(int[] arr, int s) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int diff = s - arr[i];
            if (map.containsKey(diff)) {
                int cnt = map.get(diff);
                for (int j = 0; j < cnt; j++) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(Math.min(diff, arr[i]));
                    temp.add(Math.max(diff, arr[i]));
                    res.add(temp);
                }
            }
            int c = map.containsKey(arr[i]) ? map.get(arr[i]) : 0;
            map.put(arr[i], c + 1);
        }

        Collections.sort(res, (a, b) -> a.get(0) - b.get(0));

        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ArrayList<Integer> row = res.get(i);
            ans[i][0] = row.get(0);
            ans[i][1] = row.get(1);
        }

        return ans;
    }
}
