// for count

// User function Template for Java

// class Solution {
//     // Function to find length of shortest common supersequence of two strings.
//     public static int shortestCommonSupersequence(String s1, String s2) {
//         // so bassically we are doing LCS an then do M + N - lcs
//         // why?
//         // because for fun... no im just kidding
//         // its becaue when building supersequence
//         // sequence -> order butn not continous?
//         // so i will just take only once if both matches

//         int m = s1.length();
//         int n = s2.length();

//         int[][] dp = new int[m+1][n+1];
//         // its alread filled wiht 0 so no 1st row

//         for(int i =1;i<=m;i++){
//             for(int j = 1;j<=n;j++){
//                 // now the choice dianhgram?
//                 // if same then pick one and go to diangonal
//                 // else 2: 1. reduce s1 2. reduce s2

//                 if(s1.charAt(i - 1) == s2.charAt(j-1)){
//                     // pick one and go to dianonal
//                     dp[i][j] = 1 + dp[i-1][j-1];
//                 }
//                 else{
//                     dp[i][j]  = Math.max(dp[i-1][j] , dp[i][j-1]);

//                     }
//             }
//         }

//      int lcs = dp[m][n];

//      int superseq = m + n;

//      return superseq - lcs;
//     }
// }

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        // so its basically build LCS and then start building the string
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        // all are filled with 0 so no problem

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // choice diagram
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // no choice except picking
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // now since dp is ready lets buil string
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    sb.append(str1.charAt(i - 1));
                    i--;
                } else {
                    sb.append(str2.charAt(j - 1));
                    j--;
                }
            }
        }

        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }
}
