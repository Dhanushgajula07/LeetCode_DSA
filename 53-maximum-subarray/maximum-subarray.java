class Solution {
    public int maxSubArray(int[] nums) {
        // intution is that if at any point sum is < 0 the 0 is bigger right soi make my answer as 0
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int n = nums.length;

        for(int i=0;i<n;i++){
            sum += nums[i];
             maxSum = Math.max(sum,maxSum);
            if(sum < 0){
                sum = 0;
            }
           
        }
        return maxSum;
    }
}