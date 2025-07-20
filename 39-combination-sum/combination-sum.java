class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
    // so its a backtracking pattern
    // which means i can pick and do stuff and revert back

        // pass by refernce 
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0,arr,ans,new ArrayList<>(),target);
        return ans;
    }
    public void dfs(int idx, int[] arr, List<List<Integer>> ans,ArrayList<Integer> current,int target){
        // IBH
        // base case

        if(target ==0){
            ans.add(new ArrayList<>(current));
        }
        if(target <0){
            return;
        }
        if(idx == arr.length){
            return;
        }

        // now thr hoice diagram
        // at every index i have a choce of pick or no pick
        for(int i = idx;i<arr.length;i++){
            // pick
            current.add(arr[i]);
            dfs(i,arr,ans,current,target - arr[i]);
            // backtrack
            current.remove(current.size() - 1);
        }
    }
}