// class Solution {
//     public int lengthOfLIS(int[] nums) {
//              // so basically based on thgis their are many questions that can be solved so lets make it soo soo slow and do it ok..

//              // so this is my choice diagram
//              // if(arr[i] > arr[prev]){i have choiuce of picking or nop 
//              // else no choice i shpuld skip
//              // so i should track the prev index 
//              // and previuously we solved stock rlated problems that also we use from  0 to n-1
//              // here also we will go from 0 to n-1

//              int n = nums.length;
//              // it can have -va values so i will use integer
//              Integer[][] dp = new Integer[n][n+1];
//              // so now we will shift prev
//             return solve(0,-1,nums,dp);
//     }
//     public int solve (int i,int prev,int[] arr,Integer[][] dp ){
//         // base case
//         int n = arr.length;
//         if(i == n){
//                 return 0;
//         }

//         if(dp[i][prev + 1] != null){
//             return dp[i][prev + 1];
//         }
//         // choice diagram
//         if(prev == -1 || arr[i] > arr[prev]){
//             // i have chpice of pick or no
//             int pick = 1 + solve(i + 1,i,arr,dp);
//             int nopick = solve(i+1,prev,arr,dp);
//             return dp[i][prev + 1] = Math.max(pick,nopick);
//         }
//         else{
//             return dp[i][prev + 1] = solve(i+1,prev,arr,dp);
//         }
//     }
// }



// so we will optimise it

// class Solution {
//     public int lengthOfLIS(int[] arr) {
//              int n = arr.length;
//              // it can have -va values so i will use integer
//              int[][] dp = new int[n+1][n+2];
//             // base is all 0
//         // i will come from right to left
//         for(int i = n-1;i>=0;i--){
//             for(int prev = i-1;prev>=-1;prev--){
//                         // choice diagram
//         if(prev == -1 || arr[i] > arr[prev]){
//             // i have chpice of pick or no
//             int pick = 1 + dp[i + 1][i+1];
//             int nopick = dp[i+1][prev +1];
//                 dp[i][prev + 1] = Math.max(pick,nopick);
//         }
//         else{
//             dp[i][prev + 1] = dp[i+1][prev + 1];
//         }
//             }
//         }
//         return dp[0][0];
//     }
// }


// using method for print and more

// class Solution {
//     public int lengthOfLIS(int[] arr) {
//              int n = arr.length;
//              int[] dp = new int[n];

//             // fill with 1 because singel is also valid
//             Arrays.fill(dp,1);

//              for(int i = 0;i<n;i++){
//                 for(int j = 0;j<i;j++){
//                     // check if arr[j] can be part
//                     // it basically say longest subsequence that ends at index i
//                     if(arr[i] > arr[j] && 1+dp[j] > dp[i]){
//                         // can be part
//                         dp[i] = 1+dp[j];
//                     }
//                 }
//              }

//              int max = Arrays.stream(dp).max().getAsInt();


//              return max;
//     }
// }




// now lets use Binary search 
// we use lower bound and replace that number
// offcource fomed string is not coorect but lenght is correct

import java.util.*;

class Solution {
    public int lengthOfLIS(int[] arr) {
        List<Integer> lis = new ArrayList<>();

        for (int num : arr) {
            int idx = lowerBound(lis, num);
            if (idx == lis.size()) {
                lis.add(num);  // extend LIS
            } else {
                lis.set(idx, num);  // replace with smaller value
            }
        }

        return lis.size();
    }

    // Binary search for the first index in list where element >= target
    private int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
