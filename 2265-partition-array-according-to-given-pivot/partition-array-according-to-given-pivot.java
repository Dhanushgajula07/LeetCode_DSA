class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int count_target = 0;
        int ans[] = new int[n];
        int index = 0;


        // for less than pivot
        for(int i=0;i<n;i++){
            if(nums[i] < pivot){
                ans[index] = nums[i];
                index++;
            }
            else if(nums[i] == pivot){
                count_target ++;
            }
        }

        while(count_target > 0){
            ans[index] = pivot;
            index++;
            count_target--;
        }
        for(int i=0;i<n;i++){
            if(nums[i] > pivot){
                ans[index] = nums[i];
                index++;
            }
        }


        return ans;
    }
}