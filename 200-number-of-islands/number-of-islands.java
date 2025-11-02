class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {
            {-1,0},{+1,0},{0,-1},{0,+1}
        };
        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                if((grid[i][j] == '1') && !visited[i][j]){
                    count++;
                    dfs(grid,m,n,visited,i,j,directions);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int m,int n,boolean[][] visited,int start,int end,int[][] directions){
        if(start <0 || start >= m || end <0 || end >= n || grid[start][end] == '0' || visited[start][end]){
            return;
        }

        // mark as visited
        visited[start][end] = true;
        for(int[] dir : directions){
            int newstart = start + dir[0];
            int newend = end + dir[1];
            dfs(grid,m,n,visited,newstart,newend,directions);
        }
    }
}