class Solution {
    public boolean check(int[] nums) {
        // https://youtu.be/Vzs_vlCIFEw?si=r-eqFmixAvFSdknb

        int count = 1;
        int n = nums.length;
        if(n == 1) return true;

        for(int i = 1;i<= 2 * n;i++){
            if(nums[(i - 1) % n] <= nums[i % n]){
                count++;
            }
            else{
                count = 1;
            }
            if(count == n) return true;
        }
        return false;
    }
}