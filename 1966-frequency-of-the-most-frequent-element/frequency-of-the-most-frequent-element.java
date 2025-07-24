// class Solution {
//     public int maxFrequency(int[] nums, int k) {
//         int n = nums.length;
//         int l = 0;
//         int ans = 0;
//         long sum = 0;  // Total sum of the current window

//         Arrays.sort(nums); // Step 1: sort the array

//         for (int r = 0; r < n; r++) {
//             sum += nums[r]; // Add current number to the window sum

//             // Check if window is valid
//             long tohave = (long)(r - l + 1) * nums[r]; // total required sum to make all elements nums[r]
//             long got = sum + k; // what we can afford using k increments

//             while (tohave > got) {
//                 sum -= nums[l]; // remove leftmost element
//                 l++;
//                 tohave = (long)(r - l + 1) * nums[r]; // update for new window
//                 got = sum + k;
//             }

//             ans = Math.max(ans, r - l + 1); // update answer
//         }

//         return ans;
//     }
// }


class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        int l=0,maxFreq=0;
        long total=0;
        Arrays.sort(nums);
        
        for(int r=0;r<nums.length;r++){
            total += nums[r];

            while((long)nums[r] * (r-l+1) - total > k){
                total -= nums[l];
                l++;
            }

            maxFreq = Math.max(maxFreq,r-l+1);
        }
        return maxFreq;        
    }
}