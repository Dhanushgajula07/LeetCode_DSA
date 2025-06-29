import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numSubseq(int[] nums, int target) {
        // Sort the array to use the two-pointer technique effectively
        Arrays.sort(nums);
        return countSubsequences(nums, target, 0, nums.length - 1);
    }

    private int countSubsequences(int[] nums, int target, int left, int right) {
        int count = 0;
        int mod = 1000000007; // To handle large numbers
        int[] power = new int[right + 1]; // Precompute powers of 2
        
        power[0] = 1;
        for (int i = 1; i <= right; i++) {
            power[i] = (power[i - 1] * 2) % mod; // Calculate powers of 2 modulo mod
        }

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                count = (count + power[right - left]) % mod; // Count valid subsequences
                left++; // Move left pointer to the right
            } else {
                right--; // Move right pointer to the left
            }
        }
        
        return count; // Return the total count of valid subsequences
    }
}