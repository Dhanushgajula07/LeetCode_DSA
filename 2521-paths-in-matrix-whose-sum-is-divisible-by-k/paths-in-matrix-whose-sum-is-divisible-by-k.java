// class Solution {
//     int m, n, k;
//     int[][] grid;
//     int count = 0;
//     int MOD = 1_000_000_007;

//     public int numberOfPaths(int[][] grid, int k) {
//         this.grid = grid;
//         this.k = k;
//         m = grid.length;
//         n = grid[0].length;

//         dfs(0, 0, grid[0][0]);
//         return count;
//     }

//     private void dfs(int i, int j, int sum) {
//         // base case: reached destination
//         if (i == m - 1 && j == n - 1) {
//             if (sum % k == 0)
//                 count = (count + 1) % MOD;
//             return;
//         }

//         // move down
//         if (i + 1 < m) {
//             dfs(i + 1, j, sum + grid[i + 1][j]);
//         }

//         // move right
//         if (j + 1 < n) {
//             dfs(i, j + 1, sum + grid[i][j + 1]);
//         }
//     }
// }


class Solution {
    Integer[][][] dp;
    int[][] grid;
    int m, n, k;
    int MOD = 1_000_000_007;

    public int numberOfPaths(int[][] grid, int k) {
        this.grid = grid;
        this.k = k;
        m = grid.length;
        n = grid[0].length;
        dp = new Integer[m][n][k];

        return dfs(0, 0, grid[0][0] % k);
    }

    private int dfs(int i, int j, int rem) {
        // Base case: reached bottom-right
        if (i == m - 1 && j == n - 1) {
            return rem % k == 0 ? 1 : 0;
        }

        if (dp[i][j][rem] != null) return dp[i][j][rem];

        long ways = 0;

        // move down
        if (i + 1 < m) {
            int newRem = (rem + grid[i + 1][j]) % k;
            ways += dfs(i + 1, j, newRem);
        }

        // move right
        if (j + 1 < n) {
            int newRem = (rem + grid[i][j + 1]) % k;
            ways += dfs(i, j + 1, newRem);
        }

        return dp[i][j][rem] = (int)(ways % MOD);
    }
}
