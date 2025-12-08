class Solution {
    public int searchInsert(int[] nums, int target) {
        // its the 1st elemnt which is >= target
        // ranges is 0 to n-1
        int n = nums.length;
        // chekc condition is target
        int ans = n;
        int low = 0,high = n -1;
        while(low <= high){
            int mid  = low + (high - low) /2;
            if(nums[mid] >= target){
                // found but can try low
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }
}