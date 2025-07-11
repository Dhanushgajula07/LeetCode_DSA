// class Solution {
//     public int maxSumAfterPartitioning(int[] arr, int k) {
//         // its a for loop based recursion and at every index i have a choice of picking 1,2,3 no of elemnts
//         // and at every pick of number entire that part becomes that max value of that set
//          int n = arr.length;
//         int[] memo = new int[n]; // dp[i] means max sum from index i to end
//         Arrays.fill(memo, -1);
//         return solve(0, arr, k, memo);
//     }

//     public int solve(int i, int[] arr, int k, int[] memo) {
//         int n = arr.length;
//         if (i == n) return 0;

//         if (memo[i] != -1) return memo[i];

//         int maxVal = 0;
//         int maxAns = 0;

//         // Try all valid partitions starting from i to i + k - 1
//         for (int j = i; j < Math.min(i + k, n); j++) {
//             maxVal = Math.max(maxVal, arr[j]);  // max in current partition
//             int length = j - i + 1;
//             int total = maxVal * length + solve(j + 1, arr, k, memo);
//             maxAns = Math.max(maxAns, total);  // take the max of all choices
//         }

//         return memo[i] = maxAns;
//     }
// }


class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        Integer[] dp = new Integer[n]; // memoization array
        return solve(0, arr, k, dp);
    }

    public int solve(int i, int[] arr, int k, Integer[] dp) {
        if (i == arr.length) return 0;
        if (dp[i] != null) return dp[i];

        int maxVal = 0;
        int maxSum = 0;

        // Try all partitions from i to i + k - 1 (but within bounds)
        for (int j = i; j < Math.min(i + k, arr.length); j++) {
            maxVal = Math.max(maxVal, arr[j]);
            int length = j - i + 1;
            int sum = maxVal * length + solve(j + 1, arr, k, dp);
            maxSum = Math.max(maxSum, sum);
        }

        return dp[i] = maxSum;
    }
}
