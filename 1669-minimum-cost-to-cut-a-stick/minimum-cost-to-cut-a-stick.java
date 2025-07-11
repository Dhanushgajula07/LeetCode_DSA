// class Solution {
//     public int minCost(int n, int[] cuts) {
//         //at 1st glance i thougt it was a unbounded knapsack but tghen i read the question completely and everything changed
//         // its MCM type
//         // why?
//         // becaues at eberyindex given in the arr i can make a cut... remember its not that you can cut at any ewhere you can cut at inly at the given positions
//         //another thing about this is that if we cut randomly thry will dependent on that left part 
//         // so remove that dependency we will sort it
//         Arrays.sort(cuts);
//         // next the tricky part is to get the valid i,j,k and formula to calculate temp
//         int[] newCuts = new int[cuts.length + 2];
//         newCuts[0] = 0;
//         newCuts[newCuts.length - 1] = n;
//         for (int i = 0; i < cuts.length; i++)
//             newCuts[i + 1] = cuts[i];
//         Arrays.sort(newCuts);

//         // k can go from complete i to j
//         // and also base case also can go till i==j

//         // now lests memo 
//         int[][] memo = new int[n][n];
//         for(int [] arr : memo){
//             Arrays.fill(arr,-1);
//         }
//          return solve(1, cuts.length, newCuts,memo); // ✅ range is (1 to cuts.length)
//     }

//     public int solve(int i, int j, int[] arr,int[][] memo) {
//         if (i > j)
//             return 0;
//         if(memo[i][j] != -1)
//             return memo[i][j];
//         int min = Integer.MAX_VALUE;
//         // now lest cut it
//         for (int k = i; k <= j; k++) {
//             // now the actual game begins
//             // to find the current cost
//             // cost is the actual length of thr compete stick that you aRE CUTTING
//             // how to find it?
//             // its j - i
//             // solve(i, k - 1, arr) + solve(k + 1, j, arr)
//             int temp = solve(i, k-1, arr,memo) + solve(k+1, j, arr,memo) + arr[j + 1] - arr[i - 1];
//             min = Math.min(min, temp);
//         }
//         return memo[i][j] = min;
//     }
// }


// stack memort should br optimised


class Solution {
    public int minCost(int n, int[] cuts) {
        //at 1st glance i thougt it was a unbounded knapsack but tghen i read the question completely and everything changed
        // its MCM type
        // why?
        // becaues at eberyindex given in the arr i can make a cut... remember its not that you can cut at any ewhere you can cut at inly at the given positions
        //another thing about this is that if we cut randomly thry will dependent on that left part 
        // so remove that dependency we will sort it
        Arrays.sort(cuts);
        int c = cuts.length;
        // next the tricky part is to get the valid i,j,k and formula to calculate temp
        int[] newCuts = new int[cuts.length + 2];
        newCuts[0] = 0;
        newCuts[newCuts.length - 1] = n;
        for (int i = 0; i < cuts.length; i++)
            newCuts[i + 1] = cuts[i];
        

        // k can go from complete i to j
        // and also base case also can go till i==j

        // now lests memo 
        int[][] memo = new int[c + 2][c + 2];

         // i from last towards front, j from i+1 to end
        for (int i = c; i >= 1; i--) {
            for (int j = i; j <= c; j++) {
        int min = Integer.MAX_VALUE;
        // now lest cut it
        for (int k = i; k <= j; k++) {
            // now the actual game begins
            // to find the current cost
            // cost is the actual length of thr compete stick that you aRE CUTTING
            // how to find it?
            // its j - i
            // solve(i, k - 1, arr) + solve(k + 1, j, arr)
            int temp = memo[i][k-1] + memo[k+1][j] + newCuts[j + 1] - newCuts[i - 1];
            min = Math.min(min, temp);
        }
         memo[i][j] = min;
    }
}
return memo[1][c];  // Final answer for entire segment from 0 to n
    }
}