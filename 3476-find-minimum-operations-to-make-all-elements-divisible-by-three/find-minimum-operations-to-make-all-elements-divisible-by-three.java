class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for(int num : nums){
            int mod = num % 3;

            if(mod != 0) 
            count += Math.min(mod, 3 - mod);
        }

        return count;
    }
}