class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        int[] dp = new int[value];
        for (int i : nums){
            int mod = ((i % value) + value) % value;
            dp[mod]++;
        }
        int min_idx = n + 1, min_mod = n + 1;
        for (int i = 0; i < value; i++){
            if (dp[i] < min_mod){
                min_mod = dp[i];
                min_idx = i;
            }
        }
        return min_mod * value + min_idx;
    }
}