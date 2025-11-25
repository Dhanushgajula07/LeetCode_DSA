class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int ans = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int streak= 1;
                int curr = num;
                while(set.contains(curr +1)){
                    streak++;
                    curr = curr + 1;
                }
                // search for num + 1
                ans = Math.max(ans,streak);
            }
        }
        return ans;
    }
}