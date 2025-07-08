// class Solution {
//     public boolean isMatch(String s, String p) {
//         // my choice diagram is that
//         // if matcked then ok and if ? also very good
//         // else * then for loop 0 <-- j
//         return solve(s.length() - 1, p.length() - 1, s, p);
//     }

//     public boolean solve(int i, int j, String s, String p) {
//         if (i < 0 && j < 0)
//             return true;

//         if (i < 0 && j >= 0) {
//             for (int ii = 0; ii <= j; ii++) {
//                 if (p.charAt(ii) != '*')
//                     return false;
//             }
//             return true;
//         }

//         // 
//         if (i >= 0 && j >= 0) {
//             if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
//                 // matched
//                 return solve(i - 1, j - 1, s, p);
//             } else if (p.charAt(j) == '*') {
//                 // if p is *
//                 return solve(i - 1, j, s, p) || solve(i, j - 1, s, p);
//             }
//         }
//         return false;
//     }
// }

class Solution {
    public boolean isMatch(String s, String p) {
        // my choice diagram is that
        // if matcked then ok and if ? also very good
        // else * then for loop 0 <-- j
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // now tricky part is to convert this to table
        // Empty string vs empty pattern = match
        dp[0][0] = true;

        // First row (s is empty) vs pattern
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = false;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?') {
                    // matched
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j-1) == '*') {
                    // if p is *
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}