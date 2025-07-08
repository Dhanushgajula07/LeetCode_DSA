class Solution {
    public int maxProfit(int[] prices) {
        // its just simple upate min to buy
        int max = 0;
        int buy = prices[0];
        for(int i = 1;i<prices.length;i++){
            if(prices[i] < buy) buy = prices[i];
            max = Math.max(max,prices[i] - buy);
        }
        return max;
    }
}