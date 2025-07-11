// class Solution {
//     public int minCut(String s) {
//       // so its like    Palindrome Partitioning I we solved in recursion and backtracking
//       // it was all the palindromes
//       // here minimum cuts that's the diffrence
//       // we do for loop based recursion ok...!

//       // lets memo
//       int n = s.length();
//       int[] memo = new int[n];
//       Arrays.fill(memo,-1);
//       return solve(0,s,memo) - 1;
//     }
//     public int solve(int i,String s,int[] memo){
//         int n = s.length();
//         if(i == n){
//             return 0;
//         }

//         if(memo[i] != -1){
//             return memo[i];
//         }
//         int min = Integer.MAX_VALUE;
//         // for loop based
//         for(int j = i;j<n;j++){
//             if(isPalindrome(i,j,s)){
//                 int count = 1 + solve(j + 1,s,memo);    
//             min = Math.min(min,count);
//             }
//         }
//         return memo[i] = min;
//     }
//     public boolean isPalindrome(int i,int j,String s){
//         while(i < j){
//             if(s.charAt(i) != s.charAt(j))
//             return false;
//             i++;
//             j--;
//         }
//         return true;
//     }
// }




class Solution {
    public int minCut(String s) {
      // so its like    Palindrome Partitioning I we solved in recursion and backtracking
      // it was all the palindromes
      // here minimum cuts that's the diffrence
      // we do for loop based recursion ok...!

      // lets memo
      int n = s.length();
      int[] memo = new int[n + 1];
memo[n] = 0;
        for(int i = n -1 ;i>=0;i--){
        int min = Integer.MAX_VALUE;
        // for loop based
        for(int j = i;j<n;j++){
            if(isPalindrome(i,j,s)){
                int count = 1 + memo[j + 1];
            min = Math.min(min,count);
            }
        }
         memo[i] = min;
        }
        return memo[0] - 1;
    }
    public boolean isPalindrome(int i,int j,String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }
}