class Solution {
    public void solveSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        solve(0, 0, board, m, n);
    }

    public boolean solve(int row, int col, char[][] board, int m, int n) {
        if (row == m) {
            return true;
        }

        int nextRow = (col == n - 1) ? row + 1 : row;
        int nextCol = (col == n - 1) ? 0 : col + 1;

        if (board[row][col] != '.') {
            return solve(nextRow, nextCol, board, m, n);
        }

        for (int i = 1; i <= 9; i++) {
            if (isPossible(board, row, col, i, m, n)) {
                board[row][col] = (char) (i + '0');
                if (solve(nextRow, nextCol, board, m, n)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    public boolean isPossible(char[][] board, int row, int col, int num, int m, int n) {
        char ch = (char) (num + '0');

        for (int i = 0; i < n; i++) {
            if (board[row][i] == ch) return false;
        }

        for (int j = 0; j < m; j++) {
            if (board[j][col] == ch) return false;
        }

        int newi = (row / 3) * 3;
        int newj = (col / 3) * 3;

        for (int i = newi; i < newi + 3; i++) {
            for (int j = newj; j < newj + 3; j++) {
                if (board[i][j] == ch) return false;
            }
        }

        return true;
    }
}
