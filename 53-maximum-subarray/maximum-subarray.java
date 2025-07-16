class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];
        int n = nums.length;
        for(int i = 1;i<n;i++){
            sum = Math.max(sum + nums[i],nums[i]);
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}