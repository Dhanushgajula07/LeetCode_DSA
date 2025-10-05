class Solution { //https://youtu.be/lAl_ZIKP1xI?si=NX42LJBplXjUjNrr ------> best
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // MY APPROACH
        // \U0001f9e0 Your Approach — Defined in Key Points:
        // Iterate Over Every Cell in the grid (nested loops over i and j).
        // For Each Cell (i, j):
        // Run DFS1: Try to move top and left only.
        // If this DFS can reach the top or left border, mark it as can reach Pacific.
        // Run DFS2: Try to move bottom and right only.
        // If this DFS can reach the bottom or right border, mark it as can reach Atlantic.
        // Check Both Results:
        // If both DFS1 and DFS2 returned true → add cell (i, j) to the final answer.
        // TC & SC : 
        // TC = O(m * n * (m + n))
        // ⚠️ This can be slow for large grids (up to 200 × 200), hence leads to TLE.
        // SC = O(m * n) (dominated by visited matrices)


        // optimal:
         // Run two DFS traversals: one from Pacific edge, one from Atlantic edge
        // In each DFS, only move to neighbors with height >= current
        // Mark reachable cells for each ocean
        // Final result = cells that are reachable in both traversals

        int n = heights.length;
        int m = heights[0].length ;
        boolean[][] specific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        // now mark  | for both specific and atlantic
                //   |
                //   V

        for(int i = 0;i<n;i++){
            // mark specific
            mark(i,0,-1,-1,specific,heights);
            // mark atlantic
            mark(i,m-1,-1,-1,atlantic,heights);
        }

        // now mark  -----> for both specific and atlantic

        for(int i = 0;i<m;i++){
            // mark specific
            mark(0,i,-1,-1,specific,heights); //4
            // mark atlantic
            mark(n-1,i,-1,-1,atlantic,heights);
        }

        // now finla and most intresting
        List<List<Integer>> ans = new ArrayList<>();
        // chekc if both true then add
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(atlantic[i][j] && specific[i][j]){
                    ArrayList<Integer> index = new ArrayList<>();
                    index.add(i);
                    index.add(j);
                    ans.add(index);
                }
            }
        }

        return ans;
    }
    private static void mark(int i,int j, int oi,int oj,boolean[][] arr,int[][] heights){
        // base case
        if(i<0 || j<0 || i>= arr.length || j>= arr[0].length || arr[i][j] ||
        (oi >= 0 && oj >= 0 && heights[oi][oj] > heights[i][j])){ // 0,0 ---> will be alredy valid so
        // we are coming in reverse then it should be decending order
            return;
        }
        
        arr[i][j] = true;
        // all 4 direction
        mark(i+1,j,i,j,arr,heights);
        mark(i-1,j,i,j,arr,heights);
        mark(i,j+1,i,j,arr,heights);
        mark(i,j-1,i,j,arr,heights);
        
    }
}