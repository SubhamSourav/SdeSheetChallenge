import java.util.*;

public class _2LIS {

    public static int longestIncreasingSubsequence(int arr[]) {
        int n = arr.length;
        List<Integer> seq = new ArrayList<>();
        seq.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (seq.get(seq.size() - 1) < arr[i]) {
                seq.add(arr[i]);
            } else {
                int l = 0, h = seq.size() - 1;
                while (l <= h) {
                    int m = l + (h - l) / 2;
                    if (arr[i] <= seq.get(m)) {
                        h = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                seq.set(l, arr[i]);
            }
        }
        return seq.size();
    }
}