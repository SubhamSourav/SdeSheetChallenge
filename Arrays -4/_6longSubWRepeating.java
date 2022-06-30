import java.util.HashMap;
import java.util.Map;

public class _6longSubWRepeating {
    public static int uniqueSubstrings(String s) {
        Map<Character, Integer> charlind = new HashMap<>();
        int c = 0, l = 0, r = 0;

        while (r < s.length()) {
            if (charlind.containsKey(s.charAt(r))) {
                l = Math.max(charlind.get(s.charAt(r)) + 1, l);
            }
            charlind.put(s.charAt(r), r);
            c = Math.max(c, r - l + 1);
            r++;
        }
        return c;
    }
}
