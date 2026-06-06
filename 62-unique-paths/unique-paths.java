class Solution {
    public int uniquePaths(int m, int n) {
    // so its the count based and we know that if its counting based we can solve it using dp
    // its recursion and backtracking if it was to generate all
    // we should do have a memo table
    int[][] memo = new int[m][n];
    for(int[] row : memo){
        Arrays.fill(row,-1);
    }
    int ans = solve(0,0,m,n,memo);
    return ans;
    }

    public int solve(int i, int j, int m, int n,int[][] memo){
        if(i >= m || j >= n) return 0;
        if(i == m- 1 && j == n-1) return 1;

        if(memo[i][j] != -1) return memo[i][j];

        int down = solve(i + 1,j,m,n,memo);
        int right = solve(i,j+1,m,n,memo);
        memo[i][j] = down + right;
        return memo[i][j];
    }
}



// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         // steps to convert 
//         // 1. declare base case
//         // 2. express all the states in for loops
//         // 3. copy the recurence and change function calls to dp[][]

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 // Move right and down
                
//                     int left =0;
//                     int up = 0;
//                 if (i == 0 && j == 0){
//                     dp[i][j] = 1;
//                 }
//                 else {
//                    if(j > 0)  left = dp[i][j - 1];
//                    if(i > 0) up = dp[i - 1][j];
//                     dp[i][j] = left + up;
//                 }
//             }
//         }
//         return dp[m - 1][n - 1];
//     }
// }