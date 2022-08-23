import java.util.*;

public class _9maxOfMinInWin {
    public static int[] maxMinWindow(int[] a, int n) {
        int[] ans = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && a[s.peek()] >= a[i]) {
                s.pop();
            }
            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        s.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && a[s.peek()] >= a[i]) {
                s.pop();
            }
            right[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        Arrays.fill(ans, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            ans[len - 1] = Math.max(ans[len - 1], a[i]);
        }

        for (int i = n - 2; i >= 0; i--)
            ans[i] = Math.max(ans[i], ans[i + 1]);

        return ans;
    }
}
