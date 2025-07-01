class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

         // Initialize
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0; // 0 coins needed to make amount 0
        }
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = (int) 1e9; // Impossible to make amount j with 0 coins
        }

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<= amount;j++){
                if(coins[i - 1] <= j){
                    int pick = (coins[i - 1] <= j) ? 1 + dp[i][j - coins[i - 1]] : (int) 1e9;
                    int nopick = dp[i-1][j];
                    dp[i][j] = Math.min(pick,nopick);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount] >= 1e9 ? -1 : dp[n][amount];
    }
}