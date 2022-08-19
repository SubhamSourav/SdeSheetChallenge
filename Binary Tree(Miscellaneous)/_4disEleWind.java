import java.util.*;

public class _4disEleWind {

    public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int c = map.containsKey(arr.get(i)) ? map.get(arr.get(i)) : 0;
            map.put(arr.get(i), c + 1);
        }
        ans.add(map.size());
        for (int i = k; i < arr.size(); i++) {
            int c = map.containsKey(arr.get(i)) ? map.get(arr.get(i)) : 0;
            map.put(arr.get(i), c + 1);
            c = map.get(arr.get(i - k));
            if (c == 1)
                map.remove(arr.get(i - k));
            else
                map.put(arr.get(i - k), c - 1);
            ans.add(map.size());
        }
        return ans;
    }
}
