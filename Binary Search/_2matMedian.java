import java.util.ArrayList;

public class _2matMedian {
    static int count(ArrayList<Integer> row, int ele) {
        int l = 0, h = row.size() - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (row.get(m) <= ele)
                l = m + 1;
            else
                h = m - 1;
        }
        return l;
    }

    public static int getMedian(ArrayList<ArrayList<Integer>> matrix) {
        int l = 1, h = 100000, N = matrix.size(), M = matrix.get(0).size();

        while (l <= h) {
            int m = l + (h - l) / 2, c = 0;
            for (int i = 0; i < N; i++) {
                c += count(matrix.get(i), m);
            }

            if (c <= (N * M) / 2)
                l = m + 1;
            else
                h = m - 1;
        }

        return l;
    }
}