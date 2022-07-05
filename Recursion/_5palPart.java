import java.util.ArrayList;
import java.util.List;

public class _5palPart {

    static boolean palindrome(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }

        return true;
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        part(res, new ArrayList<>(), 0, s);
        return res;
    }

    static void part(List<List<String>> res, List<String> list, int idx, String s) {

        if (idx == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (palindrome(s, idx, i)) {
                list.add(s.substring(idx, i + 1));
                part(res, list, i + 1, s);
                list.remove(list.size() - 1);
            }
        }

    }
}
