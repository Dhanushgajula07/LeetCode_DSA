// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         int sum = 0;
//         for (int num : nums) {
//             sum += num;
//         }
        
//         // If the absolute target is greater than the sum, it's impossible to achieve the target
//         if (Math.abs(target) > sum) {
//             return 0;
//         }
        
//         // The target sum range is [-sum, sum], hence we use sum * 2 + 1 for the size of dp array
//         int n = nums.length;
//         int offset = sum; // Offset to handle negative indices
//         int[][] dp = new int[n + 1][2 * sum + 1];
        
//         // Base case: There is one way to achieve the sum 0 (by using no numbers)
//         dp[0][offset] = 1;
        
//         // Fill the dp table
//         for (int i = 1; i <= n; i++) {
//             int num = nums[i - 1];
//             for (int j = -sum; j <= sum; j++) {
//                 if (dp[i - 1][j + offset] > 0) {
//                     dp[i][j + num + offset] += dp[i - 1][j + offset];
//                     dp[i][j - num + offset] += dp[i - 1][j + offset];
//                 }
//             }
//         }
        
//         // Return the number of ways to achieve the target sum
//         return dp[n][target + offset];
//     }
// }


class Solution {
    int[] dp;
    public int findTargetSumWays(int[] nums, int target) {
        // use DP
        // assume that we have S1 - S2 = target && S1 + S2 = sum ==> S1 = (target + sum)/2
        // it means that we need to find the number of subsets that have sum = (target + sum)/2
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //System.out.println("target+sum:" + (target+sum));
        if (target > sum || target + sum < 0 || (target+sum)%2 != 0) {
            return 0;
        }
        //System.out.println("---");
        int targetSum = (target + sum)/2;
        // we use DP to represents the number of subset that have sum equals targetSum
        dp = new int[targetSum+1]; 
        dp[0] = 1; // we have at least one way to have sum = 0 as empty subset

        countSubsets(nums, 0, targetSum);
        return dp[targetSum];
    }

    private void countSubsets(int[] nums, int index, int targetSum) {
        if (index == nums.length) {
            return;
        }
        
        for (int j=targetSum; j>=nums[index]; j--) {
            dp[j] += dp[j-nums[index]];
        }
        countSubsets(nums, index+1, targetSum);
    }

    /* backtracking
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, 0, target, 0);
    }

    private int backtrack(int[] nums, int index, int target, int currentSum) {
        if (index == nums.length) {
            return (currentSum == target) ? 1 : 0;
        }
        int add = backtrack(nums, index+1, target, currentSum+nums[index]);
        int sub = backtrack(nums, index+1, target, currentSum-nums[index]);
        return add+sub;
    }*/
}