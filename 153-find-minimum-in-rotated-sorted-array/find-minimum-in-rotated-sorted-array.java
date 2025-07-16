class Solution {
    public int findMin(int[] nums) {
     // so one thing is clear that im using Binay Seasrch to solve this 
     // why? beacuse im searching for something and constarain i want is o (log n)
     // now... 
     // how and where 
     // if you absover we are sure that min elelment is always in the unsorted part so we acan remove the half part
     // core logic of BS is thatremove the half that is not is use

     // so here its half with sorted valuse ..... but
     // what if its sorted + min is also mid so for safety we save the mid
      int n = nums.length;   

      return binarysearch(0,n-1,nums);
    }
    public int binarysearch(int l,int r, int[] nums){
        
        int ans = Integer.MAX_VALUE;
        while(l <= r){
            int mid = l + (r-l) /2;
            ans = Math.min(ans,nums[mid]);
        if(nums[mid] <= nums[r]){
            
            r = mid -1;
        }
        else{
            l = mid + 1;
        }
        }
        return ans;
    }
}