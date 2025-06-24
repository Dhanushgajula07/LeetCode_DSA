class Solution {
//     ✅ left + right works for Type 1 and some Type 6 (count total ways).
// But for others:

// \U0001f6ab Not always valid:
// Type 2 (Backtracking):
// You don’t count using left + right.
// You usually track valid paths in a list or count++ manually only when constraints are met.

// Type 3 (Minimax):
// You use max() / min(), not count. It’s about who wins, not how many ways.

// Type 4 (All partitions):
// You loop over i to n and try all cuts → You count inside the loop, not just left/right.

// Type 5 (Include/Exclude with constraint):
// Sometimes yes (like house robber), but usually you take max(), not count.

    public int findTargetSumWays(int[] arr, int target) {
       int count = fun(arr,0,0,target);
        //System.out.println(count);
        return count;
    }
public static int fun(int[] arr,int sum,int index,int target){
    if(index == arr.length ){
        if(sum == target){
            return 1;
        }
        return 0;
    }
    
    // induction and hypothesios
    
    // i can pick + or -ve
    // so 2 diffrent calls for each
    int left  = fun(arr,sum + arr[index],index + 1,target);
    int right = fun(arr,sum - arr[index],index + 1,target);
    return left + right;
}
}