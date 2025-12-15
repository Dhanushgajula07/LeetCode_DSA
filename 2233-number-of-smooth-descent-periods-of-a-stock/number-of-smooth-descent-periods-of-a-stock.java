class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 1; // first day is always a descent period
        long streak = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                streak++;
            } else {
                streak = 1;
            }
            ans += streak;
        }
        return ans;
    }
}