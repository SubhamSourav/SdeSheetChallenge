import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class _5subarrWithXorK {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {

        int c = 0, xor = 0;
        Map<Integer, Integer> prefcnt = new HashMap<>();

        for (int ele : arr) {
            xor = xor ^ ele;

            if (xor == x)
                c++;

            int y = xor ^ x;
            if (prefcnt.containsKey(y))
                c += prefcnt.get(y);

            int cnt = prefcnt.containsKey(xor) ? prefcnt.get(xor) : 0;
            prefcnt.put(xor, cnt + 1);
        }
        return c;
    }
}
