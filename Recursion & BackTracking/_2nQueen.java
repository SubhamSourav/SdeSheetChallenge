import java.util.*;

public class _2nQueen {

    static void nqueen(ArrayList<ArrayList<Integer>> ans, int[][] board, int row, int n, int[] cHash, int[] fHash,
            int[] sHash) {
        if (row == n) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp.add(board[i][j]);
                }
            }
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cHash[col] != 1 && fHash[row + col] != 1 && sHash[row - col + n - 1] != 1) {
                cHash[col] = 1;
                fHash[row + col] = 1;
                sHash[row - col + n - 1] = 1;
                board[row][col] = 1;
                nqueen(ans, board, row + 1, n, cHash, fHash, sHash);
                board[row][col] = 0;
                cHash[col] = 0;
                fHash[row + col] = 0;
                sHash[row - col + n - 1] = 0;
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[][] board = new int[n][n];
        int[] cHash = new int[n];
        int[] fHash = new int[2 * n - 1];
        int[] sHash = new int[2 * n - 1];
        nqueen(ans, board, 0, n, cHash, fHash, sHash);
        return ans;
    }
}
