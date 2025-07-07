class Solution {
    public int minDistance(String s1, String s2) {
        // so its basically we do S1.length - LCS
        // take an example and walk thorugh you will get it

        // lcs
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        int len = dp[m][n];

        return (m - len) + (n - len); // = m + n - 2 * len
    }
}