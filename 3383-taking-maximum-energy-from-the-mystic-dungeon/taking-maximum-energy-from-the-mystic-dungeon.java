class Solution {
    // public int maximumEnergy(int[] energy, int k) {
    //     // so lets start with brute -> recursion -> memo -> tabulation -> space optimisation
    //     // its multi entry point
    //     int max = Integer.MIN_VALUE;

    //     int n = energy.length;
    //     for(int i = 0;i<n;i++){
    //         // start at every point
    //         int sum = 0;
    //         int j = i;
    //         while(j < n){
    //             sum += energy[j];
    //             j = j + k;
    //         }
    //         max = Math.max(max,sum);
    //     }

    //     return max;
    // }

    // now lets try to convert to recursion
    // public int maximumEnergy(int[] energy, int k) {
    //     // recursion approach
    //     int max = Integer.MIN_VALUE;
    //     for(int i = 0;i<energy.length;i++){
    //         int sum  = solve(energy,i,k);
    //         max = Math.max(max,sum);
    //     }
    //     return max;
    // }
    // public int solve(int[] arr,int idx,int k){
    //     // base case
    //     if(idx >= arr.length){
    //         return 0;
    //     }

    //     return arr[idx] + solve(arr, idx + k,k);
    // }

//     public int maximumEnergy(int[] energy, int k) {
//         // now lets convery recursion to memoisation
//         // and remember its left to right
//         int max = Integer.MIN_VALUE;
//         int [] dp = new int[energy.length];
//         Arrays.fill(dp,-1);

//         for (int i = 0; i < energy.length; i++) {
//             int sum = solve(energy, i, k,dp);
//             max = Math.max(max, sum);
//         }
//         return max;
//     }

//     public int solve(int[] arr, int idx, int k,int[] dp) {
//         // base case
//         if (idx >= arr.length) {
//             return 0;
//         }
//         // base case 2
//         if(dp[idx] != -1){
//             return dp[idx];
//         }

//         dp[idx] = arr[idx] + solve(arr,idx + k,k,dp);
//         return dp[ idx];
//     }


public int maximumEnergy(int[] energy, int k) {
// Now lest solve it using Tabulation
// and remember now ist from right to left
    int[] dp = new int[energy.length];
    // base case to initilisation
    // nothing to initialise

    // no of state changes to no of loops
    for(int i = energy.length - 1;i>=0;i--){
        // now function call to dp
        // returbn dp[0]
        if(i + k < energy.length){
        dp[i] = energy[i] + dp[i + k];
        }
        else{
            dp[i] = energy[i];
        }
    }
    // now answer is max of all
    int max = Integer.MIN_VALUE;
    for(int val : dp){
        max = Math.max(max,val);
    }
    return max;
}
}