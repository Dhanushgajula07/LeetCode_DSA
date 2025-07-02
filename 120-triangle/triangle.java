class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       int n =  triangle.size();
        int[][] memo = new int[n][n];
        for(int[] arr : memo) {
            Arrays.fill(arr,-1);
        }
        return helper(0,0,triangle,memo);
    }
    public int helper(int i,int j,List<List<Integer>> triangle,int[][] memo){
        int n = triangle.size();

        if(i==n - 1){
            return triangle.get(i).get(j);
        }
        
        if(memo[i][j] != -1) return memo[i][j];

        int left = helper(i+1,j,triangle,memo);
        int right = helper(i+1,j+1,triangle,memo);
        return memo[i][j] = triangle.get(i).get(j) + Math.min(left,right);
    }
}