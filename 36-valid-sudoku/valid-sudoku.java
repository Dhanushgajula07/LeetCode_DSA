class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(board[i][j] != '.'){
                    char val =  board[i][j];
                    if(! dfs(i,j,val,m,n,board)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private boolean dfs(int row,int col,char val,int m,int n,char[][] board){
        // IBH
        // base 
        // check row
        // -----> i same but j change
        int rowcount = 0;
        for(int j = 0;j<n;j++){
            if(j != col && board[row][j] == val){
                rowcount++;
            }
        }
        

        int colcount = 0;
        for(int i=0;i<m;i++){
            if(i != row && board[i][col] == val){
                colcount++;
            }
        }

       

        // now box
        int boxcount=0;
        int newrow = (row / 3) * 3;
        int newcol = (col / 3) * 3;

        for(int i=newrow;i<newrow+3;i++){
            for(int j=newcol;j<newcol+3;j++){
                if((i != row && j != col) && board[i][j] == val){
                    boxcount++;
                }
            }
        }        
        if(boxcount >0 || rowcount > 0 || colcount > 0) return false;

        return true;
    }
}