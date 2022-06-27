import java.util.ArrayList;

public class _2pascalsTriangle {

    public static ArrayList<ArrayList<Long>> printPascal(int n) {
        ArrayList<ArrayList<Long>> ans = new ArrayList<>();
        ArrayList<Long> row, pre = null;

        for (int i = 0; i < n; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    row.add(1L);
                else {
                    row.add(pre.get(j) + pre.get(j - 1));
                }
            }
            ans.add(row);
            pre = row;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
