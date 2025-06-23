class Solution {
    public String convert(String s, int numRows) {
      if (numRows == 1) return s;

        int m = numRows;
        int estimatedCols = s.length(); // Estimate columns generously
        char[][] board = new char[m][estimatedCols];

        for (char[] row : board) {
            Arrays.fill(row, '-');
        }

        int row = 0;
        int col = 0;
        int idx = 0;

        while (idx < s.length()) {
            // Fill down vertically
            while (row < m && idx < s.length()) {
                board[row++][col] = s.charAt(idx++);
            }

            row = m - 2;  // step back to second-last row
            col++;        // move to next column

            // Fill diagonally up
            while (row > 0 && idx < s.length()) {
                board[row--][col++] = s.charAt(idx++);
            }

            // After diagonal, row will be 0, loop continues
        }


    // martix is buiilt 
    StringBuilder sb = new StringBuilder();

    for(int i = 0;i<m;i++){
        for(int j = 0;j<estimatedCols;j++){
            if(board[i][j] != '-'){
                sb.append(board[i][j]);
            }
        }
    }
    return sb.toString();
    }
}