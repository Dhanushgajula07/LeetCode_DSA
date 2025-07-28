// // import java.util.*;

// // class Solution {
// //     public List<List<Integer>> subsetsWithDup(int[] nums) {
// //         Arrays.sort(nums);  // Important: sort to group duplicates
// //         List<List<Integer>> ans = new ArrayList<>();
// //         generate(0, nums, new ArrayList<>(), ans);
// //         return ans;
// //     }

// //     private void generate(int index, int[] nums, List<Integer> current, List<List<Integer>> ans) {
// //         ans.add(new ArrayList<>(current));

// //         for (int i = index; i < nums.length; i++) {

// //             // Skip duplicates (only on the same recursive level)
// //             if (i > index && nums[i] == nums[i - 1]) continue;

// //             current.add(nums[i]);
// //             generate(i + 1, nums, current, ans);  // move to next index
// //             current.remove(current.size() - 1);
// //         }
// //     }
// // }




// import java.util.*;

// class Solution {
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         Arrays.sort(nums);  // Group duplicates
//         List<List<Integer>> ans = new ArrayList<>();
//         backtrack(0, nums, new ArrayList<>(), ans);
//         return ans;
//     }

//     private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> ans) {
//         if (index == nums.length) {
//             ans.add(new ArrayList<>(current));
//             return;
//         }

//         // 1️⃣ Pick current element
//         current.add(nums[index]);
//         backtrack(index + 1, nums, current, ans);
//         current.remove(current.size() - 1); // Backtrack

//         // 2️⃣ Skip current and all duplicates of current
//         while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
//             index++;
//         }
//         backtrack(index + 1, nums, current, ans);
//     }
// }




import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Optional: helps produce consistent order
        Set<List<Integer>> set = new HashSet<>();
        generate(0, nums, new ArrayList<>(), set);
        return new ArrayList<>(set);
    }

    private void generate(int index, int[] nums, List<Integer> current, Set<List<Integer>> set) {
        if (index == nums.length) {
            set.add(new ArrayList<>(current)); // HashSet removes duplicates
            return;
        }

        // Pick
        current.add(nums[index]);
        generate(index + 1, nums, current, set);

        // Not Pick
        current.remove(current.size() - 1);
        generate(index + 1, nums, current, set);
    }
}
