class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid= new char[m][n];
        for(char[] row : grid){
            Arrays.fill(row,'.');
        }
        int[][] directions = {
            {-1,0},{+1,0},{0,-1},{0,+1}
        };
        for(int i =0;i<walls.length;i++){
            int x = walls[i][0];
            int y = walls[i][1];
                grid[x][y] = 'W';
        }

        for(int i = 0;i<guards.length;i++){
                // place and call dfs on that cell
                 int x = guards[i][0];
                int y = guards[i][1];
                grid[x][y] = 'G';
                // dfs(grid,x,y,m,n,directions);
        }

    //     int count = 0;
    //     for(int i=0;i<m;i++){
    //         for(int j = 0;j<n;j++){
    //             if(grid[i][j] == '.') count++;
    //         }
    //     }

    //     return count;
    // }

    // // backtracking logic
    // public void dfs(char[][] grid,int start,int end,int m,int n,int[][] directions){
    //         // base cse
    //         if(start < 0 || start >= m || end < 0 || end >= n || grid[start][end] == 'G' || grid[start][end] == 'W'){
    //             return;
    //         }

    //         if (grid[start][end] == '.') {
    //         grid[start][end] = '#'; // mark as guarded
    //             }
                
    //         // calls
    //         for(int[] dir : directions){
    //            int newstart = start + dir[0];
    //             int newend = end + dir[1];
    //             dfs(grid,newstart,newend,m,n,directions);
    //         }

        // For each guard, mark visible cells
        for (int[] g : guards) {
            for (int[] dir : directions) {
                int x = g[0] + dir[0];
                int y = g[1] + dir[1];

                while (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 'W' && grid[x][y] != 'G') {
                    if (grid[x][y] == '.') {
                        grid[x][y] = '#'; // guarded cell
                    }
                    x += dir[0];
                    y += dir[1];
                }
            }
        }

        // Count unguarded cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '.') count++;
            }
        }

        return count;
    }
}