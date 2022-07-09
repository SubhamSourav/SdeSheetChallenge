import java.util.*;

public class _6wordBreak {

    static void sentence(String s, Set<String> set, ArrayList<String> ans, ArrayList<String> temp) {
        if (s.length() == 0) {
            StringBuilder sb = new StringBuilder();
            int i;
            for (i = 0; i < temp.size() - 1; i++) {
                sb.append(temp.get(i));
                sb.append(" ");
            }
            sb.append(temp.get(i));
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.substring(0, i + 1))) {
                temp.add(s.substring(0, i + 1));
                sentence(s.substring(i + 1), set, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }

    }

    public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
        ArrayList<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String str : dictionary) {
            set.add(str);
        }
        sentence(s, set, ans, new ArrayList<>());
        return ans;
    }
}
