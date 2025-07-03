// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;

//         int[][] dp = new int[m][n];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }

//         // multiple sources
//         int min = Integer.MAX_VALUE;
//         for(int j = 0;j<n;j++){
//             //n columns
//             min = Math.min(min,solve(0,j,matrix,dp));
//         }
//         return min;
//     }
//     public int solve(int i,int j,int[][] matrix,int[][]dp){
//         // bottom u[p approach
//     // gopint from index 0, any. to n,any
//     int m = matrix.length;
//     int n = matrix[0].length;
//     // base case?
//     // since i is already cheked
//     // i need to just check j
//     if(j<0 || j >= n){
//         return Integer.MAX_VALUE;
//     }
//     if(i == m-1 ){
//         return matrix[i][j];
//     }

//     if(dp[i][j] != -1){
//         return dp[i][j];
//     }

// // i have 3 method to call
// int down = solve(i+1,j,matrix,dp);
// int left = solve(i+1,j-1,matrix,dp);
// int right = solve(i+1,j+1,matrix,dp);

// int val = matrix[i][j] + Math.min(left,Math.min(right,down));
// return dp[i][j] = val;
//     }
// }



// now lets code it form dp
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        // now bottom to top
        // fill the base cases
        // with martix in thelast row of dp
        
        // initialistion
        for(int j = 0;j<n;j++){
            //n columns
            dp[m-1][j] = matrix[m-1][j];
        }
        
        // lets fill
        // for loop on every state chnage
        for(int i=m-2;i>=0;i--){
            for(int j= 0;j<n;j++){
                 // i have 3 method to call
    int down = dp[i+1][j];
    int left = (j>0) ? dp[i+1][j-1] : Integer.MAX_VALUE;
    int right = (j < n-1) ? dp[i+1][j+1]: Integer.MAX_VALUE;

     dp[i][j] = matrix[i][j] + Math.min(left,Math.min(right,down));
            }
        }

int min = Integer.MAX_VALUE;
for(int j = 0;j<n;j++){
    min = Math.min(min,dp[0][j]);
}
    return min;
}
}