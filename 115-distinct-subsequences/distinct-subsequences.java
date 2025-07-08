class Solution {
    public int numDistinct(String s, String t) {
        // so its like i have choice of pick or no pick if the char mnatches
        // else i have no choice but to try thr next char
        // this is my choice diagram     
        int m = s.length();
        int n = t.length();
        Integer [][] dp = new Integer[m][n];
        return solve(m-1,n-1,s,t,dp);
    }
    public int solve(int i,int j,String s,String t,Integer[][] dp){
        if(j <0) return 1;
        if(i<0) return 0;

        // memo
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
            // i have choice either take it or try for other occurance
            int pick = solve(i-1,j-1,s,t,dp);
            int nopick = solve(i-1,j,s,t,dp);
            return dp[i][j] = pick + nopick;  
        }
        else{
            return dp[i][j] = solve(i-1,j,s,t,dp);
        }

    }
}