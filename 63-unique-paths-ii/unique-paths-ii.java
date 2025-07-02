class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        for(int[] arr : memo){
            Arrays.fill(arr,-1);
        }
        return helper(m - 1, n - 1, obstacleGrid,memo);
    }

    public int helper(int i, int j, int[][] obstacleGrid,int[][] memo) {
        if (i < 0 || j < 0 || obstacleGrid[i][j] == 1) return 0;
        // source us blocked
        if (i == 0 && j == 0) return obstacleGrid[0][0] == 1 ? 0 : 1;
        if(memo[i][j] != -1) return memo[i][j];

        int up = helper(i - 1, j, obstacleGrid,memo);
        int left = helper(i, j - 1, obstacleGrid,memo);
        return memo[i][j] = up + left;
    }
}
