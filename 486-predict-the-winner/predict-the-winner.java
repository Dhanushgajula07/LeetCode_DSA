class Solution {
    public boolean predictTheWinner(int[] nums) {
        return dfs(nums, 0, nums.length - 1, 0, 0, true);
    }

    public boolean dfs(int[] nums, int left, int right, int p1_sum, int p2_sum, boolean p1_turn) {
        // base case: no elements left
        if (left > right) {
            return p1_sum >= p2_sum;
        }

        if (p1_turn) {
            // pick left
            if (dfs(nums, left + 1, right, p1_sum + nums[left], p2_sum, false)) {
                return true;
            }
            // pick right
            if (dfs(nums, left, right - 1, p1_sum + nums[right], p2_sum, false)) {
                return true;
            }
            return false; // if neither leads to a win
        } else {
            // pick left
            if (!dfs(nums, left + 1, right, p1_sum, p2_sum + nums[left], true)) {
                return false;
            }
            // pick right
            if (!dfs(nums, left, right - 1, p1_sum, p2_sum + nums[right], true)) {
                return false;
            }
            return true; // if both lead to a win for player 1
        }
    }
}
