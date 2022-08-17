import java.util.*;

public class _6wordBreak {
    public static Boolean wordBreak(String[] arr, int n, String target) {
        Set<String> set = new HashSet<>();
        for (String ele : arr) {
            set.add(ele);
        }

        int[] dp = new int[target.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                String word = target.substring(j, i + 1);
                if (set.contains(word)) {
                    if (j > 0)
                        dp[i] += dp[j - 1];
                    else
                        dp[i] += 1;
                }
            }
        }

        return dp[target.length() - 1] > 0;
    }
}