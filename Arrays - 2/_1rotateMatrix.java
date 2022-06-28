import java.util.ArrayList;

public class _1rotateMatrix {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int t = 0, b = n - 1, l = 0, r = m - 1;
        if (b == 0 || r == 0)
            return;

        while (t < b && l < r) {
            int prev = mat.get(t).get(l);
            for (int i = l + 1; i <= r; i++) {
                int curr = mat.get(t).get(i);
                mat.get(t).set(i, prev);
                prev = curr;
            }
            for (int i = t + 1; i <= b; i++) {
                int curr = mat.get(i).get(r);
                mat.get(i).set(r, prev);
                prev = curr;
            }
            for (int i = r - 1; i >= l; i--) {
                int curr = mat.get(b).get(i);
                mat.get(b).set(i, prev);
                prev = curr;
            }
            for (int i = b - 1; i >= t; i--) {
                int curr = mat.get(i).get(l);
                mat.get(i).set(l, prev);
                prev = curr;
            }
            t++;
            b--;
            l++;
            r--;
        }
    }
}
