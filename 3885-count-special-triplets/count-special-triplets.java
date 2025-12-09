// class Solution {
//     int MOD = 1000_000_007;
//     public int specialTriplets(int[] nums) {
//        int count = 0;
//         int n = nums.length;
//         for(int i = 0;i<n;i++){
//             for(int j = i + 1;j<n;j++){
//                 for(int k = j+ 1;k<n;k++){
//                     if(nums[i] == nums[j] * 2 && nums[k] == nums[j] * 2){
//                         count++;
//                     }
//                 }
//             }
//         }
//         return count % MOD;
//     }
// } 
// so since its o(n^3) TLE

class Solution {
    public int specialTriplets(int[] nums) {
        int MOD = 1_000_000_007;
        int n = nums.length;
        long ans = 0;

        // Map to count occurrences to the left of j
        Map<Integer, Integer> left = new HashMap<>();
        // Map to count occurrences to the right of j
        Map<Integer, Integer> right = new HashMap<>();

        // Fill right map with counts of each value
        for (int num : nums) {
            right.put(num, right.getOrDefault(num, 0) + 1);
        }

        // Iterate j from left to right
        for (int j = 0; j < n; j++) {
            right.put(nums[j], right.get(nums[j]) - 1); // Remove current j from right

            int need = nums[j] * 2;
            int leftCount = left.getOrDefault(need, 0);
            int rightCount = right.getOrDefault(need, 0);

            ans = (ans + ((long) leftCount * rightCount) % MOD) % MOD;

            // Add current j to left
            left.put(nums[j], left.getOrDefault(nums[j], 0) + 1);
        }

        return (int) ans;
    }
}