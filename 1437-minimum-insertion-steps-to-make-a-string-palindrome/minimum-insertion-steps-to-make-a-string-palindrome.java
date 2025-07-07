class Solution {
    public int minInsertions(String s1) {
        StringBuilder sb = new StringBuilder(s1);
        String s2 = sb.reverse().toString();

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
        return m - dp[m][n];
    }
}