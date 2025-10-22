class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        if (nums.length == 0) 
            return 0;
        Arrays.sort(nums);
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) 
            freq.put(x, freq.getOrDefault(x, 0) + 1);

        int ans = 1;

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int key = e.getKey(), val = e.getValue();
            int low = key - k, high = key + k;

            int left  = lowerBound(nums, low);          
            int right = upperBound(nums, high);         

            int inRange  = right - left;
            int visited  = inRange - val;
            int minLoop  = Math.min(visited, numOperations);
            ans = Math.max(ans, val + minLoop);
        }

        int l = 0;
        for (int r = 0; r < n; r++) {
            while (l <= r && nums[r] - nums[l] > 2 * k) l++;
            int w = r - l + 1;
            ans = Math.max(ans, Math.min(w, numOperations));
        }
        return ans;
    }

    private int lowerBound(int[] a, int target) {
        int l = 0, r = a.length; 
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] < target) l = m + 1; else r = m;
        }
        return l;
    }


    private int upperBound(int[] a, int target) {
        int l = 0, r = a.length; 
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] <= target) l = m + 1; else r = m;
        }
        return l;
    }
}