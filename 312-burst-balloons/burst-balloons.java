// class Solution {
//     public int maxCoins(int[] nums) {
//         // so now its the same as of the MCM
//         // the only tweek is that the parts are not independent because when a ballop burst all the left and rigth ballons will shift
//         // exceopt this everything is same
//         // so how to overcome?
//         // soring will not help and its very wrong because while count pints
//         // i need the exact left and rigth coins count
//         // 1st add 1 not 0 at the both ends
//         // now assume we are solving in reverse order and consided each ballon is the last and calcuklate
//         // coins = coin[i - 1] * coin[k] * coin[j+1]; j + 1 assuming its the last ballon
        
//         int[] newCuts = new int[nums.length + 2];
//         newCuts[0] = 1; // 1 because multiplication
//         newCuts[newCuts.length - 1] = 1;
//         for (int i = 0; i < nums.length; i++)
//             newCuts[i + 1] = nums[i];
//             int n = newCuts.length;
//         int[][] memo = new int[n][n];
//         for(int[] arr : memo){
//             Arrays.fill(arr,-1);
//         }
//         return solve(1,nums.length ,newCuts,memo);
//     }
//     public int solve(int i ,int j,int[] nums,int[][] memo){
//         if(i > j) return 0;
//         if(memo[i][j] != -1){
//             return memo[i][j];
//         }
//         int max = Integer.MIN_VALUE;
//         for(int k = i;k<=j;k++){
//             int temp = solve(i,k-1,nums,memo) + solve(k+1,j,nums,memo) + nums[i - 1] * nums[k] * nums[j+1];
//             max = Math.max(max,temp);
//         }
//         return memo[i][j] =  max;
//     }
// }


// now lest tabulation
class Solution {
    public int maxCoins(int[] nums) {
        // so now its the same as of the MCM
        // the only tweek is that the parts are not independent because when a ballop burst all the left and rigth ballons will shift
        // exceopt this everything is same
        // so how to overcome?
        // soring will not help and its very wrong because while count pints
        // i need the exact left and rigth coins count
        // 1st add 1 not 0 at the both ends
        // now assume we are solving in reverse order and consided each ballon is the last and calcuklate
        // coins = coin[i - 1] * coin[k] * coin[j+1]; j + 1 assuming its the last ballon
        
        int[] newCuts = new int[nums.length + 2];
        newCuts[0] = 1; // 1 because multiplication
        newCuts[newCuts.length - 1] = 1;
        for (int i = 0; i < nums.length; i++)
            newCuts[i + 1] = nums[i];
            int n = nums.length;
        int[][] memo = new int[n+2][n+2];
        // 1 ,nums length
        for(int i = n ;i>=1;i--){
            for(int j = i;j<=n;j++){
        int max = Integer.MIN_VALUE;
        for(int k = i;k<=j;k++){
            int temp = memo[i][k-1] + memo[k+1][j] + newCuts[i - 1] * newCuts[k] * newCuts[j+1];
            max = Math.max(max,temp);
        }
         memo[i][j] =  max;
            }
        }
        return memo[1][n];
    }
}