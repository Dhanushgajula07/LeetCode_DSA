class Solution {
        // so basically if we sort it and do LIS we will get the answer
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        // Sort the array
        Arrays.sort(nums);

        int n = nums.length;
        int[] dp = new int[n]; // dp[i] will store the size of the largest subset ending with nums[i]
        int[] parent = new int[n]; // To reconstruct the subset
        int maxSize = 0; // Keep track of the maximum size of subset
        int maxIndex = -1; // Index of the last element in the largest divisible subset

        // Initialize the dp array
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        // Build the dp array and parent array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) { // If the current number is divisible by nums[j]
                    if (dp[j] + 1 > dp[i]) { // Check if we found a larger subset
                        dp[i] = dp[j] + 1;
                        parent[i] = j; // Update the parent to reconstruct later
                    }
                }
            }
            // Update maximum size and index if we found a larger subset
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        // Reconstruct the largest divisible subset
        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) { // Backtrack from the last index
            result.add(nums[maxIndex]);
            maxIndex = parent[maxIndex]; // Move to the parent
        }

        // The result is constructed backward; reverse it
        Collections.reverse(result);
        
        return result;
    }
}
