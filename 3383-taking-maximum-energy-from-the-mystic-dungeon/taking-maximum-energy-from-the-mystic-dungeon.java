// class Solution {
//     public int maximumEnergy(int[] energy, int k) {
//         int n = energy.length;
//         int maxEnergy = Integer.MIN_VALUE;

//         for (int i = 0; i < n; i++) {
//             int val = dfs(energy, i, k);
//             maxEnergy = Math.max(maxEnergy, val);
//         }

//         return maxEnergy;
//     }

//     private int dfs(int[] arr, int i, int k) {
//         if (i >= arr.length) return 0;
//         return arr[i] + dfs(arr, i + k, k);
//     }
// }



// class Solution {
//     public int maximumEnergy(int[] energy, int k) {
//         int n = energy.length;
//         Integer[] dp = new Integer[n];  // memo array
//         int maxEnergy = Integer.MIN_VALUE;

//         for (int i = 0; i < n; i++) {
//             int val = dfs(energy, i, k, dp);
//             maxEnergy = Math.max(maxEnergy, val);
//         }

//         return maxEnergy;
//     }

//     private int dfs(int[] arr, int i, int k, Integer[] dp) {
//         if (i >= arr.length) return 0;
//         if (dp[i] != null) return dp[i];

//         dp[i] = arr[i] + dfs(arr, i + k, k, dp);
//         return dp[i];
//     }
// }

// tabulation

class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int maxEnergy = Integer.MIN_VALUE;

        // Fill from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (i + k < n)
                dp[i] = energy[i] + dp[i + k];
            else
                dp[i] = energy[i];

            maxEnergy = Math.max(maxEnergy, dp[i]);
        }

        return maxEnergy;
    }
}
