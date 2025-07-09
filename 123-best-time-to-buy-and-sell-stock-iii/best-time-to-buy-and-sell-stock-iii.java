class Solution {
    public int maxProfit(int[] prices) {
        // i did come up with choice diagram
        // if buy flag then i have choice to buy or no buy
        // else nobuy flag then i have choice to sell or no sell

        // recursion
        // 1. i should represent everything in the form of index
        // 2. do everything or explore all the things that should be done 
        // 3. now retuen what question asked
        // 4. be sure with base cases
        int n = prices.length;
        // 3d table 
        int[][][] dp = new int[n][2][3]; // trans can be 0,1,2
        for(int i =0;i<n;i++){
            for(int j= 0;j<2;j++){
                for(int k = 0;k<3;k++){
            dp[i][j][k] = -1; 
                }
            }
        } 
        return solve(0,prices,1,dp,2);
    }
    public int solve(int i,int[] prices,int buy,int[][][] dp,int transitions){
        int n = prices.length;
        if(i == n || transitions == 0){
            return 0;
        }
        if(dp[i][buy][transitions] != -1) return dp[i][buy][transitions];
        int profit;
        if(buy == 1){
            // i can buy or no
            int buyed = -prices[i] + solve(i+1,prices,0,dp,transitions);
            int skip = 0 + solve(i+1,prices,1,dp,transitions);
            profit =  Math.max(buyed,skip); 
        }
        else{
            int sell = prices[i] + solve(i+1,prices,1,dp,transitions - 1);
            int skip = 0 + solve(i+1,prices,0,dp,transitions);
            profit =   Math.max(sell,skip);
        }
        return dp[i][buy][transitions] = profit;
    }
}
