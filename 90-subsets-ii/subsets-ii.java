class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>> ans  = new ArrayList<>();
        // since it sould not have any duplicate that means i should somehow remove the repeating elemnt so
        // sort and compare the previous elmemnt
        Arrays.sort(arr);
        generate(arr,0,new ArrayList<>(),ans);
        return ans;
    }
    public void generate(int[] arr,int idx,ArrayList<Integer> current,List<List<Integer>> ans){
        // base case
        
            ans.add(new ArrayList<>(current));
       

        // pick call remove call but no duplicates
        // so i will use the for loop based recursion and just check some condition
        for(int i = idx;i<arr.length;i++){

            // check
            if(i > idx && arr[i] == arr[i-1])
            continue;

            current.add(arr[i]);
            generate(arr,i + 1,current,ans);
            current.remove(current.size() -1);
        } 
    }
}