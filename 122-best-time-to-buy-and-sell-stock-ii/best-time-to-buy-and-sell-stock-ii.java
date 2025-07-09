// class Solution {
//     public int maxProfit(int[] prices) {
//         // i did come up with choice diagram
//         // if buy flag then i have choice to buy or no buy
//         // else nobuy flag then i have choice to sell or no sell

//         // recursion
//         // 1. i should represent everything in the form of index
//         // 2. do everything or explore all the things that should be done 
//         // 3. now retuen what question asked
//         // 4. be sure with base cases
//         int n = prices.length;
//         int[][] dp = new int[n][2];
//         for(int i =0;i<n;i++){
//             for(int j= 0;j<2;j++){
//             dp[i][j] = -1; 
//             }
//         } 
//         return solve(0,prices,1,dp);
//     }
//     public int solve(int i,int[] prices,int buy,int[][] dp){
//         int n = prices.length;
//         if(i == n){
//             return 0;
//         }
//         if(dp[i][buy] != -1) return dp[i][buy];
//         int profit;
//         if(buy == 1){
//             // i can buy or no
//             int buyed = -prices[i] + solve(i+1,prices,0,dp);
//             int skip = 0 + solve(i+1,prices,1,dp);
//             profit =  Math.max(buyed,skip); 
//         }
//         else{
//             int sell = prices[i] + solve(i+1,prices,1,dp);
//             int skip = 0 + solve(i+1,prices,0,dp);
//             profit =   Math.max(sell,skip);
//         }
//         return dp[i][buy] = profit;
//     }
// }


// // tabulation
// class Solution {
//     public int maxProfit(int[] prices) {
//         // i did come up with choice diagram
//         // if buy flag then i have choice to buy or no buy
//         // else nobuy flag then i have choice to sell or no sell

//         // recursion
//         // 1. i should represent everything in the form of index
//         // 2. do everything or explore all the things that should be done 
//         // 3. now retuen what question asked
//         // 4. be sure with base cases
//         int n = prices.length;
//         int[][] dp = new int[n+1][2];
//         int buy = 1;
//         // so its stock so tabulation should ne from n to 0
//         for(int i = n-1;i>=0;i--){
//             for(int j = 0;j<=1;j++){
//         if(j == 1){
//             // i can buy or no
//             int buyed = -prices[i] + dp[i+1][0];
//             int skip = 0 + dp[i+1][1];
//             dp[i][j] =  Math.max(buyed,skip); 
//         }
//         else{
//             int sell = prices[i] + dp[i+1][1];
//             int skip = 0 + dp[i+1][0];
//             dp[i][j] =   Math.max(sell,skip);
//         }
//             }
//         }
//         return dp[0][1];
//     }
// }


// just 2 1d arrays

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
        int[] next = new int[2];
        int buy = 1;
        // so its stock so tabulation should ne from n to 0
        for(int i = n-1;i>=0;i--){ // it sayd how many times i should loop 
            int[] curr = new int[2];
            for(int j = 0;j<=1;j++){
        if(j == 1){
            // i can buy or no
            int buyed = -prices[i] + next[0];
            int skip = 0 + next[1];
            curr[j] =  Math.max(buyed,skip); 
        }
        else{
            int sell = prices[i] + next[1];
            int skip = 0 + next[0]; // i have only 0 and 1 index 
            curr[j] =   Math.max(sell,skip);
        }
            }
            next = curr;
        }
        return next[1];
    }
}