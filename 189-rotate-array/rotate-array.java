class Solution {
    public void rotate(int[] nums, int k) {
        // i + k % n
        int n = nums.length;
        k = k % n;

        rotate(0,n-k-1,nums);
        rotate(n-k,n-1,nums);
        rotate(0,n-1,nums);
    }
    private void rotate(int l,int r,int[] nums){
        while(l <= r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}