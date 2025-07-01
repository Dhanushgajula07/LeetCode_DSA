class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // Base Case: 1 way to make amount 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                int notPick = dp[i - 1][j];
                int pick = 0;
                if (coins[i - 1] <= j) {
                    pick = dp[i][j - coins[i - 1]];
                }
                dp[i][j] = pick + notPick;
            }
        }

        return dp[n][amount];
    }
}
