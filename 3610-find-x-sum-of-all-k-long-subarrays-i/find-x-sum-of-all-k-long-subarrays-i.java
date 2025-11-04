import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[Math.max(1, n - k + 1)];

        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // Add current element to freq
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            // Remove element going out of window
            if (i >= k) {
                int out = nums[i - k];
                freq.put(out, freq.get(out) - 1);
                if (freq.get(out) == 0) freq.remove(out);
            }

            // Once window is ready
            if (i >= k - 1) {
                // Build a min-heap to get top x
                PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]
                );

                for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                    int val = entry.getKey();
                    int f = entry.getValue();
                    pq.offer(new int[]{val, f});
                    if (pq.size() > x) pq.poll(); // keep only top x
                }

                // Compute sum of top x elements
                int sum = 0;
                while (!pq.isEmpty()) {
                    int[] top = pq.poll();
                    sum += top[0] * top[1];
                }

                ans[i - k + 1] = sum;
            }
        }

        return ans;
    }
}
