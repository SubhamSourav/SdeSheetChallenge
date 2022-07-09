import java.util.*;

public class _1permutations {
    static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    static void perm(char[] s, List<String> ans, int idx) {
        if (idx == s.length) {
            ans.add(String.valueOf(s));
            return;
        }

        for (int i = idx; i < s.length; i++) {
            swap(s, idx, i);
            perm(s, ans, idx + 1);
            swap(s, idx, i);
        }
    }

    public static List<String> findPermutations(String s) {
        List<String> ans = new ArrayList<>();
        char[] ch = s.toCharArray();
        perm(ch, ans, 0);
        return ans;
    }

    public static void main(String[] args) {
        String s = "xyx";
        List<String> ls = findPermutations(s);

        System.out.println(ls);

    }

}