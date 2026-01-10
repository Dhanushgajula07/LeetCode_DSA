// // greedy approACH FAILS
// class Solution {
//     public int minimumDeleteSum(String s1, String s2) {
//         int i = 0;
//         int j = 0;
//         int m = s1.length();
//         int n = s2.length();
        
//         int ans =0;
//         while(i < m && j < n){
//             if(s1.charAt(i) == s2.charAt(j)){
//                 i++;
//                 j++;
//             }
//             else{
//                 int asci = getAsc(s1.charAt(i));
//                 int ascj = getAsc(s2.charAt(j)) ;
//                 if(asci > ascj){
//                     ans += asci;
//                     i++;
//                 }
//                 else{
//                     ans += ascj;
//                     j++;
//                 }
//             }
//         }
//         while(i<m){
//             ans += getAsc(s1.charAt(i));
//             i++;
//         }
//         while(j<n){
//             ans += getAsc(s2.charAt(j));
//             j++;
//         }
//         return ans;
//     }
//     // method top get asci val;ues of a  chartater 
//     private int getAsc(char c){
//         int ascii =  (int) c;
//         return ascii;
//     }
// }



// LETS TRY DP

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
         int m = s1.length();
        int n = s2.length();
        // DP array for memoization; initialized to -1
        int[][] dp = new int[m][n];
       for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(0, 0, m, n, s1, s2, dp);
    }
    public int helper(int i, int j,int m,int n, String s1, String s2,int[][] dp){
        if(i == m && j == n){
            return 0;
        }

        if(i == m){
            // return sum of all s2 chars
            int sum = 0;
            for(int k = j; k < n;k++){
                sum += (int) s2.charAt(k);
            }
            return sum;
        }
        if(j == n){
            // only for 
            int sum = 0;
            for(int k = i;k<m;k++){
                sum += (int) s1.charAt(k);
            }
            return sum;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            // call for ++i and ++j
            dp[i][j] = helper(i + 1,j + 1,m,n,s1,s2,dp);
        }
        else{
            int dels1 = (int) s1.charAt(i) + helper(i + 1,j,m,n,s1,s2,dp);
            int dels2 = (int) s2.charAt(j) + helper(i,j + 1,m,n,s1,s2,dp);
            dp[i][j] = Math.min(dels1,dels2);
        }
        
        // else onlt the i have a choice and decisions

        return dp[i][j];
    }
}