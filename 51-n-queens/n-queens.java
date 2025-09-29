class Solution {
    public List<List<String>> solveNQueens(int n) {
        // 1st i will get my n X n board
        char[][] board = boardCreater(n);

        // 2. we will creata an aswers
        List<List<String>> ans = new ArrayList<>();
        
        //3. lets call solve metod for finding all possiblities
        solve(0,n,board,ans);

        return ans;
    }
    public char[][] boardCreater(int n){
        // this method will return me a n* n checs board filled with .'s'

        char[][] board = new char[n][n];

        for(char[] row : board){
            Arrays.fill(row,'.');
        }
        return board;
    }
    // 2. solve
    public void solve(int col,int n,char[][] board,List<List<String>> ans){
        // base case
        if(col == n){
            // reached end by putting all th equesns
            List<String> converted= convetBoard(board);
            ans.add(converted);
            return;
        }

        // now lets actually solve it its imsple buut efective
        // for each col go thoru all the rows
        for(int row = 0;row < n;row++){
            // check if you can put their or noi
            boolean canPut = canPut(board,row,col,n);
            if(canPut){
                // pick
                board[row][col] = 'Q';
                solve(col+1,n,board,ans);
                // remove
                board[row][col] = '.';
            }
        }
    }

    public List<String> convetBoard(char[][] board){
        List<String> converted  = new ArrayList<>();
        for(char[] row : board){
            converted.add(new String(row));
        }
        return converted;
    }
    public boolean canPut(char[][] board, int row ,int col,int n){
    // ✅ FIX: Instead of returning true when filled, return false if any 'Q' is found

        // ✅ FIX: Don't mutate original row & col. Use temp variables
        int c = col - 1;
        // check left in the same row
        while (c >= 0) {
            if (board[row][c] == 'Q') return false; // ✅ FIX: return false if queen found
            c--;
        }

        // ✅ FIX: reset row & col for upper-left diagonal
        int r = row - 1;
        c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') return false; // ✅ FIX
            r--;
            c--;
        }

        // ✅ FIX: reset for lower-left diagonal
        r = row + 1;
        c = col - 1;
        while (r < n && c >= 0) {
            if (board[r][c] == 'Q') return false; // ✅ FIX
            r++;
            c--;
        }

        return true; // ✅ FIX: return true if it's safe
    }
}