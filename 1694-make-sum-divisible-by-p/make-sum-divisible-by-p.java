class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int num : nums) {
            total = (total + num) % p;
        }
        if (total == 0) return 0;

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, -1); // Prefix sum mod value to index
        long curr = 0;
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            curr = (curr + nums[i]) % p;
            long need = (curr - total + p) % p;
            if (map.containsKey(need)) {
                res = Math.min(res, i - map.get(need));
            }
            map.put(curr, i);
        }
        return res == nums.length ? -1 : res;
    }
}