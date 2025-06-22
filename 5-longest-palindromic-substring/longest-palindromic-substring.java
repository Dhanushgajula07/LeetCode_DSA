class Solution {
    public String longestPalindrome(String s) {
        // expand around the corner
        String ans = "";
        for(int i=0;i<s.length();i++){
            String odd = find(s,i,i);
            String even = find(s,i, i +1);

            if(odd.length() > ans.length()){
                ans = odd;
            }
            if(even.length() > ans.length()){
                ans = even;
            }
        }
        return ans;
    }
    // expanding around the technique
    private static String find(String s , int i, int j){
        while(i>= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i + 1,j );
    }  
}