// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//        int n =  triangle.size();
//         int[][] memo = new int[n][n];
//         for(int[] arr : memo) {
//             Arrays.fill(arr,-1);
//         }
//         return helper(0,0,triangle,memo);
//     }
//     public int helper(int i,int j,List<List<Integer>> triangle,int[][] memo){
//         int n = triangle.size();

//         if(i==n - 1){
//             return triangle.get(i).get(j);
//         }
        
//         if(memo[i][j] != -1) return memo[i][j];

//         int left = helper(i+1,j,triangle,memo);
//         int right = helper(i+1,j+1,triangle,memo);
//         return memo[i][j] = triangle.get(i).get(j) + Math.min(left,right);
//     }
// }



// since it was solved using memo but in 0 to n-1 so i guess it will be ticky for tabulation so lets see

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       int n =  triangle.size();
        int[][] dp = new int[n][n];

        // Step 1: Initialize the last row
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        // Step 2: Fill the dp table from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int down = dp[i + 1][j];
                int diag = dp[i + 1][j + 1];
                dp[i][j] = triangle.get(i).get(j) + Math.min(down, diag);
            }
        }     
       return dp[0][0];
    }
}