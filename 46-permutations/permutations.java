class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // so basically it has only one solution that is trying out all tye possible permutationsso its backtracking
        // and TC: n! and  SC : n!
        List<List<Integer>> ans = new ArrayList<>();
        int[] used = new int[nums.length];
        Arrays.fill(used,-1);
        solve(nums,0,new ArrayList<>(),ans,used);
        return ans;
    }
    private void solve(int[] arr,int idx,ArrayList<Integer> current, List<List<Integer>> ans,int[] used){
        // base case
        if(current.size() == arr.length){
            // i can add and rerturn
            ans.add(new ArrayList<>(current));
            return;
        }

        // now the actual game
        for(int i = 0;i<arr.length;i++){
            if(used[i] != 0){
                used[i] = 0;
                current.add(arr[i]);
                solve(arr,i + 1,current, ans,used);
                current.remove(current.size() -1);
                used[i] = -1;
            }
        }
    }
}