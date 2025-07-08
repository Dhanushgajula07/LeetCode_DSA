// class Solution {
//     public int numDistinct(String s, String t) {
//         // so its like i have choice of pick or no pick if the char mnatches
//         // else i have no choice but to try thr next char
//         // this is my choice diagram     
//         int m = s.length();
//         int n = t.length();
//         Integer [][] dp = new Integer[m][n];
//         return solve(m-1,n-1,s,t,dp);
//     }
//     public int solve(int i,int j,String s,String t,Integer[][] dp){
//         if(j <0) return 1;
//         if(i<0) return 0;

//         // memo
//         if(dp[i][j] != null){
//             return dp[i][j];
//         }
//         if(s.charAt(i) == t.charAt(j)){
//             // i have choice either take it or try for other occurance
//             int pick = solve(i-1,j-1,s,t,dp);
//             int nopick = solve(i-1,j,s,t,dp);
//             return dp[i][j] = pick + nopick;  
//         }
//         else{
//             return dp[i][j] = solve(i-1,j,s,t,dp);
//         }

//     }
// }

// tabulation
// class Solution {
//     public int numDistinct(String s, String t) {
//         // so its like i have choice of pick or no pick if the char mnatches
//         // else i have no choice but to try thr next char
//         // this is my choice diagram     
//         int m = s.length();
//         int n = t.length();
//         int [][] dp = new int[m+1][n+1];

//         // base case
//         // if (j<0) return 1
//         // mean when j string is "" it can be for sure formned by picking none

//         for(int j=0;j<m;j++){
//             dp[j][0] = 1;
//         }

//         // no of states =.no of looops
//         for(int i=1;i<=m;i++){
//             for(int j = 1;j<=n;j++){
//         if(s.charAt(i-1) == t.charAt(j-1)){
//             // i have choice either take it or try for other occurance
//             int pick = dp[i-1][j-1];
//             int nopick = dp[i-1][j];
//              dp[i][j] = pick + nopick;  
//         }
//         else{
//              dp[i][j] = dp[i-1][j];
//         }
//             }}

//             return dp[m][n];
//     }
// }

// so im just using i-1 and i so i just need 2 1d array

// class Solution {
//     public int numDistinct(String s, String t) {
//         // so its like i have choice of pick or no pick if the char mnatches
//         // else i have no choice but to try thr next char
//         // this is my choice diagram     
//         int m = s.length();
//         int n = t.length();
//         int[] prev = new int[n+1];

//         // base case
//         // if (j<0) return 1
//         // mean when j string is "" it can be for sure formned by picking none

//         // for(int j=0;j<m;j++){
//         //     dp[j][0] = 1;
//         // }
//         prev[0] = 1;
//         /// dp[i-v][..] -> prev[]
//         // no of states =.no of looops
//         for (int i = 1; i <= m; i++) {
//             int[] curr = new int[n+1];
//             // dont miss ihis
//             curr[0] = 1;
//             for (int j = 1; j <= n; j++) {
//                 if (s.charAt(i - 1) == t.charAt(j - 1)) {
//                     // i have choice either take it or try for other occurance
//                     int pick = prev[j - 1];
//                     int nopick = prev[j];
//                     curr[j] = pick + nopick;
//                 } else {
//                     curr[j] = prev[j];
//                 }
//             }
//             prev = curr;
//         }

//         return prev[n];
//     }
// }


// one 1d dp


class Solution {
    public int numDistinct(String s, String t) {
        // so its like i have choice of pick or no pick if the char mnatches
        // else i have no choice but to try thr next char
        // this is my choice diagram     
        int m = s.length();
        int n = t.length();
        int[] prev = new int[n+1];

        // base case
        // if (j<0) return 1
        // mean when j string is "" it can be for sure formned by picking none

        // for(int j=0;j<m;j++){
        //     dp[j][0] = 1;
        // }
        prev[0] = 1;
        /// dp[i-v][..] -> prev[]
        // no of states =.no of looops
        for (int i = 1; i <= m; i++) {
            // so 1d dp works only when we run from right to left
            for (int j = n; j >=1 ; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // i have choice either take it or try for other occurance
                    int pick = prev[j - 1];
                    int nopick = prev[j];
                    prev[j] = pick + nopick;
                } 
                // same no use
                // else {
                //     prev[j] = prev[j];
                // }
            }
        }

        return prev[n];
    }
}