// class Solution {
//     public int minDistance(String s1, String s2) {
//         // so here is my choice diagram 
//         // if matches then no problem
//         // else i can MIN(insert, delete, replace)
//         // base case is also good
//         int m = s1.length();
//         int n =s2.length();
//         return solve(m-1,n-1,s1,s2);
//     }
//     public int solve(int i,int j,String s1, String s2){
//         if(i < 0) return j +1; // deletions
//         if(j<0) return i+1; // insertions

//         if(s1.charAt(i) == s2.charAt(j)){
//             // matched 
//             return solve(i-1,j-1,s1,s2);
//         }
//         else{
//             return  1 + Math.min(
//                 solve(i,j-1,s1,s2), Math.min(
//                     solve(i-1,j,s1,s2),solve(i-1,j-1,s1,s2)
//                 )
//             );
//         }
//     }
// }


// class Solution {
//     public int minDistance(String s1, String s2) {
//         // so here is my choice diagram 
//         // if matches then no problem
//         // else i can MIN(insert, delete, replace)
//         // base case is also good
//         int m = s1.length();
//         int n =s2.length();
//         Integer [][] dp = new Integer[m][n];
//         return solve(m-1,n-1,s1,s2,dp);
//     }
//     public int solve(int i,int j,String s1, String s2,Integer [][] dp){
//         if(i < 0) return j +1; // deletions
//         if(j<0) return i+1; // insertions
        
//         if(dp[i][j] != null) return dp[i][j];

//         if(s1.charAt(i) == s2.charAt(j)){
//             // matched 
//             return dp[i][j] = solve(i-1,j-1,s1,s2,dp);
//         }
//         else{
//             return  dp[i][j] = 1 + Math.min(
//                 solve(i,j-1,s1,s2,dp), Math.min(solve(i-1,j,s1,s2,dp),solve(i-1,j-1,s1,s2,dp))
//             );
//         }
//     }
// }



// class Solution {
//     public int minDistance(String s1, String s2) {
//         // so here is my choice diagram 
//         // if matches then no problem
//         // else i can MIN(insert, delete, replace)
//         // base case is also good
//         int m = s1.length();
//         int n =s2.length();
//         int[][] dp = new int[m+1][n+1];

//           // Base cases
//         for (int i = 0; i <= m; i++) dp[i][0] = i; // delete all characters from s1
//         for (int j = 0; j <= n; j++) dp[0][j] = j; // insert all characters to s1

//         for(int i =1;i<=m;i++){
//             for(int j =1;j<=n;j++){
//         if(s1.charAt(i-1) == s2.charAt(j-1)){
//             // matched 
//              dp[i][j] = dp[i-1][j-1];
//         }
//         else{
//               dp[i][j] = 1 + Math.min(
//                 dp[i][j-1], Math.min(dp[i-1][j],dp[i-1][j-1]));
//         }
//             }
//         }
//             return dp[m][n];
//     }
// }


// now just 2 1d arrays

class Solution {
    public int minDistance(String s1, String s2) {
        // so here is my choice diagram 
        // if matches then no problem
        // else i can MIN(insert, delete, replace)
        // base case is also good
        int m = s1.length();
        int n =s2.length();
        int[] prev = new int[n+1]; // size is no of col's

          // Base cases
           for (int j = 0; j <= n; j++) {
            prev[j] = j;
        }
        for(int i =1;i<=m;i++){
            
            int[] curr = new int[n+1]; // size is no of col's
            curr[0] = i;
            for(int j =1;j<=n;j++){
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            // matched 
             curr[j] = prev[j-1];
        }
        else{
              curr[j] = 1 + Math.min(
                curr[j-1], Math.min(prev[j],prev[j-1]));
        }
            }
            prev = curr;
        }
            return prev[n];
    }
}