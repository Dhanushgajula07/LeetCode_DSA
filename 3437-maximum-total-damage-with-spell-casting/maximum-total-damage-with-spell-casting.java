import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        // Step 1: build total contribution per value
        Map<Integer, Long> total = new HashMap<>();
        for (int p : power) {
            total.put(p, total.getOrDefault(p, 0L) + p);
        }

        // Step 2: sort unique values
        List<Integer> vals = new ArrayList<>(total.keySet());
        Collections.sort(vals);

        // Step 3: memoization array
        long[] memo = new long[vals.size()];
        Arrays.fill(memo, -1);

        return helper(vals, total, 0, memo);
    }

    private long helper(List<Integer> vals, Map<Integer, Long> total, int index, long[] memo) {
        if (index >= vals.size()) return 0;

        if (memo[index] != -1) return memo[index];

        // Option 1: skip current value
        long noPick = helper(vals, total, index + 1, memo);

        // Option 2: pick current value
        long pick = total.get(vals.get(index));

        // Find next index we can pick (value difference >= 3)
        int next = index + 1;
        while (next < vals.size() && vals.get(next) - vals.get(index) <= 2) {
            next++;
        }

        pick += helper(vals, total, next, memo);

        // Memoize and return
        memo[index] = Math.max(pick, noPick);
        return memo[index];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] power = {5,9,2,10,2,7,10,9,3,8};
        System.out.println(sol.maximumTotalDamage(power)); // Output: 31
    }
}
