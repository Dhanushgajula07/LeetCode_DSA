class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // unique so Hashset of list
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        int n = nums.length;
        for(int l=0;l<n-2;l++){
            int m = l + 1;
            int r = n-1;

            while(m < r){
            int sum = nums[l] + nums[m] + nums[r];
            if(sum == 0){
                List<Integer> part = new ArrayList<>();
                part.add(nums[l]);
                part.add(nums[m]);
                part.add(nums[r]);
                set.add(part);
                m++;
                r--;
                 while(m<r && nums[m] == nums[m-1]){
                m++;
            }

            while(r>m && nums[r] == nums[r + 1]){
                r--;
            }
            }
            else if(sum > 0){
                r--;
            }
            else {
                m++;
            }

           
            }
        }

        return new ArrayList<>(set);
    }
}