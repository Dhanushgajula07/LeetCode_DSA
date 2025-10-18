class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        long prev = Long.MIN_VALUE;
        for (int i : nums){
            if (prev < i - k){
                prev = i - k;
                res++;
            } else if (prev < i + k){
                prev = prev + 1;
                res++;
            }
        }
        return res;
    }
}