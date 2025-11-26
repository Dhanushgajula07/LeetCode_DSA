class Solution {
    public int firstMissingPositive(int[] nums) {
        // brute 
        // int missing = 1;

        // while(true){
        // boolean flag = true;
        // for(int num : nums){
        //     if(num == missing){
        //         flag = false;
        //         break;
        //     }
        // }
        // if(flag) return missing;
        // missing++;
        // }

        // better
        // use boolean array
        // boolean[] seen = new boolean[nums.length];
        // int n = nums.length;
        // for(int num : nums){
        //     if (num > 0 && num <= n) 
        //     seen[num - 1] = true;
        // }
        // for(int i = 0;i<n;i++){
        //     if(seen[i] == false){
        //         return i+1;
        //     }
        // }
        // return n+1;


        // optimal 1
        // use sort

        int n = nums.length;
        Arrays.sort(nums);
        int missing = 1;
        for (int num : nums) {
            if (num > 0 && missing == num) {
                missing++;
            }
        }
        return missing;
    }
}