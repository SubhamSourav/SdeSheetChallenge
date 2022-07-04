import java.util.ArrayList;

public class _6medConsOne {
    public static int longestSubSeg(ArrayList<Integer> arr, int n, int k) {
        int l = 0, r = 0;
        while (r < n) {
            if (arr.get(r) == 0)
                k--;
            if (k < 0) {
                if (arr.get(l) == 0)
                    k++;
                l++;
            }
            r++;
        }
        return r - l;
    }
}
