public class _3sudoku {
    static boolean isValid(int mat[][], int row, int col, int c) {
        for (int i = 0; i < 9; i++) {
            if (mat[row][i] == c)
                return false;
            if (mat[i][col] == c)
                return false;
            if (mat[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }

        return true;
    }

    static boolean solve(int mat[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (mat[i][j] == 0) {
                    for (int c = 1; c <= 9; c++) {
                        if (isValid(mat, i, j, c)) {
                            mat[i][j] = c;
                            if (solve(mat))
                                return true;
                            else
                                mat[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isItSudoku(int matrix[][]) {
        return solve(matrix);
    }
}
