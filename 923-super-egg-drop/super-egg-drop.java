// class Solution {
//     public int superEggDrop(int k, int n) {
//         // at 1st glance i thought it was the lower bound logic 
//         // but it's wrong. Why?
//         // because we have just few eggs so it will be costly for every mid calculation
//         // so we use the MCM yes right 
//         // at every floor we check if egg breaks or not 
//         // if yes, try lower; else try higher

//         // question:
//         // Find the Threshold such that using the given eggs wisely, 
//         // we find the min number of attempts in a worst-case scenario.
//         // So it’s like min(max) DP — yes!

//         // This is a MINIMAX DP
//         // At each floor i from 1 to N:
//         // Drop an egg → pay 1 attempt
//         // Two cases:
//         // 1. Egg breaks → check below → solve(k - 1, i - 1)
//         // 2. Egg survives → check above → solve(k, n - i)
//         // Take max (worst case)
//         // Then take min of all such attempts
//         int[][] dp = new int[k + 1][n + 1]; // ✅ Use dp[k][n] convention
//         for (int[] arr : dp) {
//             Arrays.fill(arr, -1);
//         }
//         return solve(k, n, dp);
//     }

//     public int solve(int k, int n, int[][] dp) {
//         // ✅ Memo check should come FIRST
//         if (dp[k][n] != -1) return dp[k][n];

//         // base cases
//         if (k == 1) return n; // Only 1 egg → check all floors
//         if (n == 0 || n == 1) return n;

//         int minAttempts = Integer.MAX_VALUE;

//         // Try dropping from every floor 1 to n
//         for (int i = 1; i <= n; i++) {
//             int breaks = solve(k - 1, i - 1, dp);    // egg breaks
//             int survives = solve(k, n - i, dp);      // egg survives
//             int worst = 1 + Math.max(breaks, survives); // one attempt + worst case
//             minAttempts = Math.min(minAttempts, worst);
//         }

//         return dp[k][n] = minAttempts;
//     }
// }


class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];

        // base case: with 1 egg, we need j attempts
        for (int j = 1; j <= n; j++) {
            dp[1][j] = j;
        }

        // Fill dp table
        for (int eggs = 2; eggs <= k; eggs++) {
            for (int floors = 1; floors <= n; floors++) {
                int low = 1, high = floors;
                int minAttempts = Integer.MAX_VALUE;

                // Binary search to find the optimal floor
                while (low <= high) {
                    int mid = (low + high) / 2;
                    int breakCase = dp[eggs - 1][mid - 1];   // egg breaks
                    int noBreakCase = dp[eggs][floors - mid]; // egg survives
                    int worst = 1 + Math.max(breakCase, noBreakCase);

                    if (breakCase < noBreakCase) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }

                    minAttempts = Math.min(minAttempts, worst);
                }

                dp[eggs][floors] = minAttempts;
            }
        }

        return dp[k][n];
    }
}
