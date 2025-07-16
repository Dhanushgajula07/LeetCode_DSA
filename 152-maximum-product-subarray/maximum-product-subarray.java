class Solution {
    public int maxProduct(int[] nums) {
        // so this is the question that we do it through experience:
        // if it has onlt +ve just find the product of all
        // if it has only only even no of -ve then also no problem : - * - -> + so just do it
        // but what if we have odd no of -ve then we should remove one -ve but which?
        // offcoursethre one side with the min sum

        int lsum = 1;
        int rsum = 1;
         int finalsum = Integer.MIN_VALUE;
        
        int n = nums.length;
         for(int i = 0;i<n;i++){
            lsum = (lsum == 0 ? 1 : lsum) * nums[i];
            rsum = (rsum ==0  ? 1 : rsum) * nums[n-i - 1];
            finalsum = Math.max(finalsum,Math.max(lsum,rsum));
         }
         return finalsum;
    }
}