
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        // its of type 2
        // at each col i have all the rows
        // yes i will fill collm wise because i can check only left and other left 2 corners
        // i need a method to check valid
        // and then method to convert board to List of string list

        dfs(ans,board,0);
        return ans;
    }
    public void dfs(List<List<String>> ans,char[][] board,int col){
        // base case
        if(col == board[0].length ){
            List<String> con = convert(board);
            ans.add(con);
            return;
        }

        // multiple choices and decsions
        for(int row =0;row<board.length;row++){
            if(check(board,row,col )){
                // pick call remove
                board[row][col] = 'Q';
                dfs(ans,board,col + 1);
                board[row][col] = '.';
            }
        }
    }
    public boolean check(char[][] board, int i, int j) {
    // check complete left
    int jj = j;
    while (jj >= 0) {
        if (board[i][jj] == 'Q') return false;
        jj--;
    }

    // check left top
    int ii = i, jj2 = j;
    while (ii >= 0 && jj2 >= 0) {
        if (board[ii][jj2] == 'Q') return false;
        ii--;
        jj2--;
    }

    // check left bottom
    int ii2 = i, jj3 = j;
    while (ii2 < board.length && jj3 >= 0) {
        if (board[ii2][jj3] == 'Q') return false;
        ii2++;
        jj3--;
    }

    return true;
}
    public List<String> convert (char[][] board){
        List<String> ans = new ArrayList<>();

        for(char[] row : board){
            ans.add(new String(row));
        }
        return ans;
    } 
}