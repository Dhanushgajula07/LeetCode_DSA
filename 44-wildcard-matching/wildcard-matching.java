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
        Boolean[][] dp = new Boolean[m][n];
        return solve(m-1,n-1, s, p,dp);
    }

    public boolean solve(int i, int j, String s, String p,Boolean[][] dp) {
        if (i < 0 && j < 0)
            return true;

        if (i < 0 && j >= 0) {
            for (int ii = 0; ii <= j; ii++) {
                if (p.charAt(ii) != '*')
                    return false;
            }
            return true;
        }

        if (j < 0 && i >= 0)
            return false;
            
        if(dp[i][j] != null) return dp[i][j];
        // 
        if (i >= 0 && j >= 0) {
            if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
                // matched
                return  dp[i][j] = solve(i - 1, j - 1, s, p,dp);
            } else if (p.charAt(j) == '*') {
                // if p is *
                return dp[i][j] = solve(i - 1, j, s, p,dp) || solve(i, j - 1, s, p,dp);
            }
        }
        return false;
    }
}