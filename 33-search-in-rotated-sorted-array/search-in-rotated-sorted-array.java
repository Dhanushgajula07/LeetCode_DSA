class Solution {
    public int search(int[] nums, int target) {
        // i know its the BS pattern
        int n = nums.length;

        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = low + (high - low) /2;
            if(nums[mid] == target){
                return mid;
            }
            // left part sorted and contsing elemnts
            else if(nums[low] <= nums[mid]) {
                if(nums[low] <= target && target <= nums[mid])
                high = mid - 1;
                else
                low = mid +1;
            }
            else if(nums[mid] <= nums[high]) {
                if(nums[mid] <= target && target <= nums[high]){
                // right part is sorted and it contains elemnt
                low = mid +1;
                }
                else
                high = mid -1;
            }
        }

        return -1;
    }
}