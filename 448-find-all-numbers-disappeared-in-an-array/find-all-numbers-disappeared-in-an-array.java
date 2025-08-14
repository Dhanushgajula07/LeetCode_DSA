// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         List<Integer> ans = new ArrayList<>();

//         HashSet<Integer> set = new HashSet<>();
//         for(int num : nums){
//             set.add(num);
//         }

//         for(int i = 1;i<=nums.length;i++){
//             if(! set.contains(i)){
//                 ans.add(i);
//             }
//         }

//         return ans;
//     }
// }

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        // mark the index - 1

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0)
                nums[index] = -nums[index];
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}