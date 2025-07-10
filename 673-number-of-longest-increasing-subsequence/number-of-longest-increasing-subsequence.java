class Solution {
    public int findNumberOfLIS(int[] arr) {
                     int n = arr.length;
             int[] dp = new int[n];
            // fill with 1 because singel is also valid
            Arrays.fill(dp,1);

            //i wll need the count array to tranc the count
            int[] count = new int[n];
            Arrays.fill(count,1);

            int maxLen = 1;
             for(int i = 0;i<n;i++){
                for(int j = 0;j<i;j++){
                    // check if arr[j] can be part
                    // it basically say longest subsequence that ends at index i
                    if(arr[i] > arr[j] && 1+dp[j] > dp[i]){
                        // can be part
                        dp[i] = 1+dp[j];
                    count[i] = count[j];
                    }
                    else if(dp[j] + 1 == dp[i]){
                            count[i] += count[j];
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
             }
             int result = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) {
                result += count[i];
            }
        }

        return result;
    }
}