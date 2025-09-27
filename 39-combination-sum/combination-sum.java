class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(candidates, target, 0, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void generate(int[] arr, int target, int sum, int idx, ArrayList<Integer> current, List<List<Integer>> ans) {
        // base case
        if (sum >= target) {
            if (sum == target)
                ans.add(new ArrayList<>(current));
            return;
        }

        // its all the combinations
        // its a pick or no pick based + can repeat same number multiple times

        if (sum > target || idx >= arr.length) {
            return;
        }
        // current.add(arr[idx]);
        // generate(arr,target,sum += arr[idx],idx,current,ans);
        // current.remove(current.size()-1);
        // generate(arr,target,sum -= arr[idx],idx+ 1,current,ans);
        current.add(arr[idx]);
        generate(arr, target, sum + arr[idx], idx, current, ans); // pick
        current.remove(current.size() - 1);
        generate(arr, target, sum, idx + 1, current, ans); // skip

    }
}