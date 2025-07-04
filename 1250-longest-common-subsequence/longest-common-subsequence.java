// class Solution {
//     public int longestCommonSubsequence(String s1, String s2) {
//         // so lets start with recursion and then memo and then tabulation
//         // 1. recursion
//         // base -> choice diagram -> reduce input
//         int m = s1.length();
//         int n = s2.length();
//         int dp[][] = new int[m][n];
//         for(int[] arr : dp){
//             Arrays.fill(arr,-1);
//         }
//         // return lcsR(m-1,n-1,s1,s2);
//         return lcsM(m-1,n-1,s1,s2,dp);
//     }
//     // public int lcsR(int i,int j, String s1,String s2){
//     //     // smallest valid input
//     //     if(i <0 || j<0){
//     //         return 0;
//     //     }

//     //     // now choice diagram
//     //     if(s1.charAt(i) == s2.charAt(j)){
//     //         return 1 + lcsR(i-1,j-1,s1,s2);
//     //     }
//     //     else{
//     //         return Math.max(lcsR(i-1,j,s1,s2),lcsR(i,j-1,s1,s2));
//     //     }
//     // }
//     public int lcsM(int i,int j, String s1,String s2,int[][] dp){
//         // smallest valid input
//         if(i <0 || j<0){
//             return 0;
//         }

//         if(dp[i][j] != -1){
//             // changing values
//             return dp[i][j];
//         }
//         // now choice diagram
//         if(s1.charAt(i) == s2.charAt(j)){
//             return dp[i][j] = 1 + lcsM(i-1,j-1,s1,s2,dp);
//         }
//         else{
//             return dp[i][j] = Math.max(lcsM(i-1,j,s1,s2,dp),lcsM(i,j-1,s1,s2,dp));
//         }
//     }
// }



class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        // so lets start with recursion and then memo and then tabulation
        // 1. recursion
        // base -> choice diagram -> reduce input
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];

        // initial values are filled iwth 0's

        for(int i=1;i<=m;i++){
            for(int j =1;j<=n;j++){
                
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}