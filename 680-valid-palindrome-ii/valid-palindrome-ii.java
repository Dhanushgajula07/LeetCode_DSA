class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int n = s.length();
        int j = n-1;
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)){
                int newi = i+1;
                int newj = j-1;
                if(check(newi,j,s) || check(i,newj,s)){
                    return true;
                }
                else{
                    return false;
                }
            }
            i++;
            j--;
        }

        return true;
    }
    private boolean check(int i, int j, String s){
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}