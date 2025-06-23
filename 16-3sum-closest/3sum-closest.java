class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2]; // initialize with a valid sum
        int abs = Math.abs(ans - target);      // store closest difference initially

        for (int i = 0; i < n - 2; i++) {
            // skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);

                if (diff < abs) {
                    abs = diff;
                    ans = sum;
                }

                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return ans;
    }
}
