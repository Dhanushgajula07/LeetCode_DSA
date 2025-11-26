// class Solution {
//     public int maxProfit(int[] prices) {
//     // i have a choice of buy and sell at any given day 
//     // and also i must buy before sell
//     // so i shulc chek if i aklready buied or no to sell
//     // you can buy and sell multiple times

//     // so all this will set into to recursion
//     // lets write choice diagram
//     // replrestnt everything in terms of index
//     // already done

//     // choice diagram
//     // at evey index i have choice of either buy/ no-buy if already sold
//     // if buyed then sell/ no-sell

//     int n = prices.length;
//     int flag_buy = 1;
//     return solve(0,n,flag_buy,prices);
//     }
//     private int solve(int idx,int n,int flag_buy,int[] prices){
//         if(idx == n){
//             return 0;
//         }
//         int profit = 0;
//         if(flag_buy == 1){
//             // i can buy or no buy
//             int buy = -prices[idx] + solve(idx + 1,n,0,prices);
//             // no buy
//             int no_buy = 0 + solve(idx+1,n,1,prices);
//             profit = Math.max(buy,no_buy);
//         }
//         else{
//             int sell = prices[idx] + solve(idx +1,n,1,prices);
//             int no_sell = 0 + solve(idx + 1,n,0,prices);
//             profit = Math.max(sell,no_sell);
//         }
//         return profit;
//     }
// }



class Solution { // memo
    public int maxProfit(int[] prices) {
    // i have a choice of buy and sell at any given day 
    // and also i must buy before sell
    // so i shulc chek if i aklready buied or no to sell
    // you can buy and sell multiple times

    // so all this will set into to recursion
    // lets write choice diagram
    // replrestnt everything in terms of index
    // already done

    // choice diagram
    // at evey index i have choice of either buy/ no-buy if already sold
    // if buyed then sell/ no-sell

    int n = prices.length;
    int flag_buy = 1;
    // variables are index and buy or no
    int[][] dp = new int[n + 1][2];
    for(int[] arr : dp){
        Arrays.fill(arr,-1);
    }
    return solve(0,n,flag_buy,prices,dp);
    }
    private int solve(int idx,int n,int flag_buy,int[] prices,int[][] dp){
        if(idx == n){
            return 0;
        }
        int profit = 0;
        if(dp[idx][flag_buy] != -1) return dp[idx][flag_buy];
        if(flag_buy == 1){
            // i can buy or no buy
            int buy = -prices[idx] + solve(idx + 1,n,0,prices,dp);
            // no buy
            int no_buy = 0 + solve(idx+1,n,1,prices,dp);
            profit = Math.max(buy,no_buy);
        }
        else{
            int sell = prices[idx] + solve(idx +1,n,1,prices,dp);
            int no_sell = 0 + solve(idx + 1,n,0,prices,dp);
            profit = Math.max(sell,no_sell);
        }
        return dp[idx][flag_buy] = profit;
    }
}