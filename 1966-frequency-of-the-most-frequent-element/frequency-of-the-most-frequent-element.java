class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        long total = 0; // to avoid overflow
        int maxFreq = 0;

        for (int r = 0; r < nums.length; r++) {
            total += nums[r];

            // Check if window is valid
            while ((long)(r - l + 1) * nums[r] - total > k) {
                total -= nums[l];
                l++;
            }

            maxFreq = Math.max(maxFreq, r - l + 1);
        }

        return maxFreq;
    }
}
