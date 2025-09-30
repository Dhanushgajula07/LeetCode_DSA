class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 1;
        int n = nums.length;
        int high = n - 2;

        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
     if(nums[n-1] != nums[n-2]) return nums[n-1];


        while(low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is the single element
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // Check parity and move pointers
            if(mid % 2 == 1 &&  nums[mid] == nums[mid - 1]) {
                low = mid + 1;
            } else if(mid % 2 == 0 && nums[mid] == nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
