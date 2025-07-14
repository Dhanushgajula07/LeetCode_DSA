class Solution {
    public int countSquares(int[][] matrix) {
        // its quite simple and straight forward
        // we create an dp[][] and initialise and then build the table

        // approach is that we check min of all 3 sides left,top,diagolnal and get min of all 3
        // why it works?
        // because when you do min then it cancels out the rectangles
        // how ?
        // because if its not square that mean thiir will be 0 so min is always 0

        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        // initialise
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j];
                }
            }
        }

        for(int i =1;i<m;i++){
            for(int j =1;j<n;j++){
                if(matrix[i][j] == 1){
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j] , dp[i-1][j-1])) + 1;
                }
            }
        }
        int ans = 0;
        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                ans += dp[i][j];
            }
        }

        return ans;
    }
}