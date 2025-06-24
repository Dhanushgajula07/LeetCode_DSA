class Solution {
    // mistakes 
    // 1. deep copy
    // 2. store i and alsi add i not index
    public List<List<Integer>> combinationSum(int[] arr, int target) {
    // so its of type 2 of recursion/
    // type 2
    List<List<Integer>> ans = new ArrayList<>();
    dfs(arr,ans,0,0,new ArrayList<>(),target);
    return ans; 
    }
    public void dfs(int[] arr,List<List<Integer>> ans, int sum, int index,ArrayList<Integer> list,int target){
                    if(sum == target){
                        ans.add(new ArrayList<>(list)); // deep copy
                        return;
                    }
                    if(sum > target){
                        return;
                    }
                    if(index == arr.length){
                        return;
                    }
                    
        // at each step i have choices and decisoions
        // hat to multiple choice from index + 1 to n-1
        for(int i = index;i<arr.length;i++){
            // pick call remove
            list.add(arr[i]); // not index
            dfs(arr,ans,sum + arr[i],i ,list,target);
            list.remove(list.size() - 1);
        }
    }
}