// class Solution {
//     public String convert(String s, int numRows) {
//       if (numRows == 1) return s;

//         int m = numRows;
//         int estimatedCols = s.length(); // Estimate columns generously
//         char[][] board = new char[m][estimatedCols];

//         for (char[] row : board) {
//             Arrays.fill(row, '-');
//         }

//         int row = 0;
//         int col = 0;
//         int idx = 0;

//         while (idx < s.length()) {
//             // Fill down vertically
//             while (row < m && idx < s.length()) {
//                 board[row++][col] = s.charAt(idx++);
//             }

//             row = m - 2;  // step back to second-last row
//             col++;        // move to next column

//             // Fill diagonally up
//             while (row > 0 && idx < s.length()) {
//                 board[row--][col++] = s.charAt(idx++);
//             }

//             // After diagonal, row will be 0, loop continues
//         }


//     // martix is buiilt 
//     StringBuilder sb = new StringBuilder();

//     for(int i = 0;i<m;i++){
//         for(int j = 0;j<estimatedCols;j++){
//             if(board[i][j] != '-'){
//                 sb.append(board[i][j]);
//             }
//         }
//     }
//     return sb.toString();
//     }
// }

// its time optimised  but not for space
// here is when we use String Builder in place of each row
// that changes the entire looping and converting to string


class Solution {
    public String convert(String s, int numRows) {
        // Edge case: if numRows is 1, zigzag is the string itself
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Create an array of StringBuilders for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean goingDown = false;

        // Traverse each character in the string
        for (char c : s.toCharArray()) {
            rows[currRow].append(c);

            // Change direction if we hit top or bottom row
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move to the next row depending on the direction
            currRow += goingDown ? 1 : -1;
        }

        // Combine all rows to get the final result
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
