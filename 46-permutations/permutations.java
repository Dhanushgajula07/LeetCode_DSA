class Solution {
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        // its permutation so alays from 0 index
        int n = arr.length;
        boolean[] visited = new boolean[n];
        dfs(arr,ans,new ArrayList<>(),visited);
        return ans;
    }
    public void dfs(int[] arr,List<List<Integer>> ans,ArrayList<Integer> list,boolean[] used){
        if(list.size() == arr.length){
            ans.add(new ArrayList<>(list)); // deeo copy
            return;
        }

        for(int i = 0;i<arr.length;i++){
            if(!used[i]){
                // pick call remove

                list.add(arr[i]);
                used[i] = true; // mark used from that path
                dfs(arr,ans,list,used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}



// class Solution {
//     public List<List<Integer>> permute(int[] arr) {
//         List<List<Integer>> ans = new ArrayList<>();
//         generate(0, arr, ans);
//         return ans;
//     }

//     private void generate(int index, int[] arr, List<List<Integer>> ans) {
//         // base case
//         if (index == arr.length) {
//             List<Integer> permutation = new ArrayList<>();
//             for (int num : arr) {
//                 permutation.add(num);
//             }
//             ans.add(permutation);
//             return;
//         }

//         for (int i = index; i < arr.length; i++) {
//             // swap to fix an element at index
//             swap(arr, i, index);
//             generate(index + 1, arr, ans);
//             // backtrack
//             swap(arr, i, index);
//         }
//     }

//     private void swap(int[] arr, int i, int j) {
//         int temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;
//     }
// }
