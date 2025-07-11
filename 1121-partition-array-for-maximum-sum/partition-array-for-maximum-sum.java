class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // its a for loop based recursion and at every index i have a choice of picking 1,2,3 no of elemnts
        // and at every pick of number entire that part becomes that max value of that set
         int n = arr.length;
        int[] memo = new int[n]; // dp[i] means max sum from index i to end
        Arrays.fill(memo, -1);
        return solve(0, arr, k, memo);
    }

    public int solve(int i, int[] arr, int k, int[] memo) {
        int n = arr.length;
        if (i == n) return 0;

        if (memo[i] != -1) return memo[i];

        int maxVal = 0;
        int maxAns = 0;

        // Try all valid partitions starting from i to i + k - 1
        for (int j = i; j < Math.min(i + k, n); j++) {
            maxVal = Math.max(maxVal, arr[j]);  // max in current partition
            int length = j - i + 1;
            int total = maxVal * length + solve(j + 1, arr, k, memo);
            maxAns = Math.max(maxAns, total);  // take the max of all choices
        }

        return memo[i] = maxAns;
    }
}