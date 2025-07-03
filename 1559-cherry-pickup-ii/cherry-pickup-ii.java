// class Solution {
//     public int cherryPickup(int[][] grid) {
//         // so ist of 3d dp
//         // nothing to worry about lets walk through in simple and crisp steops

//         // we understand all its question insights?
//         // 1. its like game theory recursion: multiple player playing on same grid but not simultaneously
//         // here we do play it simeltinouskly

//         // 2. now its not like max of  them seperately, its sum of them max
        
//         // 3. since they work on same grid they may overlap then we should consider only once not twice

//         // 4. when they pass thorugh a cell they get that manyt points and that cell becomes '0'
//         // and they can move in 3 directiuons

//         // 5. MAINLY its single source and multi destination
//         // so for memo and recursion we directly start from source no second thought 

//         int m = grid.length;
//         int n = grid[0].length;

//         // for 2 robots it will have i1,j1 and i2,j2
//         // but since they both travel on same grid and at same time we can use onlt i1 not i2

//         // each cell can have -1,0,+1 possible ways

//         // 0,0, and 0,n-1

        
//         return helper(0,0,n-1,grid);
//     }
//     public int helper(int i,int j1,int j2,int[][] grid){

//         int m = grid.length;
//         int n = grid[0].length;

//         // now lets deap with base case
//         // not just returning randomly we should check for collision

//         // base case 1syt out of bound
//         if(j1 <0 || j1 >n-1 || j2 <0 || j2>n-1){
//             // its -ve one sighn chnage can make all the diffrence
//             return (int) -1e8;
//         }
//         if(i == m-1){
//             // now check for collision
//             if(j1 == j2){
//                 return grid[i][j1];
//             }
//             else{
//                 return grid[i][j1] + grid[i][j2];
//             }
//         }

//         // now for each move of robo1 their can be total of 3 moves for robo2 
//         // which makes total if 9 moves
//         // represented as delta di and dj
//         int maxi = Integer.MIN_VALUE;
//         for(int dj1 = -1;dj1<=1;dj1++){
//             for(int dj2 = -1;dj2<=1;dj2++){
//                 // now same as of collision detection and solve accordinly
//                 if(j1 == j2){
//                     // i willl add only once
//                     int val = grid[i][j1] + helper(i + 1,j1+dj1,j2 + dj2,grid);
//                     maxi = Math.max(maxi,val);
//                 }
//                 else{
//                     int val = grid[i][j1] + grid[i][j2] + helper(i + 1,j1+dj1,j2+dj2,grid);
//                     maxi = Math.max(maxi,val);
//                 }
//             }
//         }

//         return maxi;
//     }
// }


class Solution {
    public int cherryPickup(int[][] grid) {
        // so ist of 3d dp
        // nothing to worry about lets walk through in simple and crisp steops

        // we understand all its question insights?
        // 1. its like game theory recursion: multiple player playing on same grid but not simultaneously
        // here we do play it simeltinouskly

        // 2. now its not like max of  them seperately, its sum of them max
        
        // 3. since they work on same grid they may overlap then we should consider only once not twice

        // 4. when they pass thorugh a cell they get that manyt points and that cell becomes '0'
        // and they can move in 3 directiuons

        // 5. MAINLY its single source and multi destination
        // so for memo and recursion we directly start from source no second thought 

        int m = grid.length;
        int n = grid[0].length;

        // for 2 robots it will have i1,j1 and i2,j2
        // but since they both travel on same grid and at same time we can use onlt i1 not i2

        // each cell can have -1,0,+1 possible ways

        // 0,0, and 0,n-1

        // now lest memoise
        // Integer because we need not fill it agian wioth -1 it willbe filled with null
        Integer [][][] dp = new Integer[m][n][n];
        // why? m because non of rows
        // n and n? because j1 and j2 will be of the same colms

        return helper(0,0,n-1,grid,dp);
    }
    public int helper(int i,int j1,int j2,int[][] grid,Integer [][][] dp){

        int m = grid.length;
        int n = grid[0].length;

        // now lets deap with base case
        // not just returning randomly we should check for collision

        // base case 1syt out of bound
        if(j1 <0 || j1 >n-1 || j2 <0 || j2>n-1){
            // its -ve one sighn chnage can make all the diffrence
            return (int) -1e8;
        }
        if(i == m-1){
            // now check for collision
            if(j1 == j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1] + grid[i][j2];
            }
        }

        if(dp[i][j1][j2] != null) return dp[i][j1][j2];
        // now for each move of robo1 their can be total of 3 moves for robo2 
        // which makes total if 9 moves
        // represented as delta di and dj
        int maxi = Integer.MIN_VALUE;
        // its the part that goes to all the dircetions
        for(int dj1 = -1;dj1<=1;dj1++){
            for(int dj2 = -1;dj2<=1;dj2++){
                // now same as of collision detection and solve accordinly
                if(j1 == j2){
                    // i willl add only once
                    int val = grid[i][j1] + helper(i + 1,j1+dj1,j2 + dj2,grid,dp);
                    maxi = Math.max(maxi,val);
                }
                else{
                    int val = grid[i][j1] + grid[i][j2] + helper(i + 1,j1+dj1,j2+dj2,grid,dp);
                    maxi = Math.max(maxi,val);
                }
            }
        }

        return dp[i][j1][j2] = maxi;
    }
}