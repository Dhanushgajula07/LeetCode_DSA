class Solution {
    public String shortestPalindrome(String s) {
        // so basically as we discussed it will boil down to finding the lps of the sting + '$' + revString
        // becaus eits the longest palindromic substring = longest pref which is also suffix (LPS)
        // which is build using KMP algotrithm

        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        String altered = s + '$' + rev;
        int n = altered.length();
        int [] lps = getLPS(altered,n);
        
        // now lets return ans
        int last = lps[n-1];

        String ans = new StringBuilder(s.substring(last)).reverse().toString() + s;

        return ans;
    }
    public int[] getLPS(String str,int n){
        int[] lps = new int[n];

        // lets build it
        int j = 0;
        int i =1;
        
        while(i < n){
            // now str matched
            if(str.charAt(i) == str.charAt(j)){
                j++;
                lps[i] = j;
                i++; 
            }
            else if(i<n && str.charAt(i) != str.charAt(j)){
                // now fall bask
                if(j != 0){
                    // can fallback
                    j = lps[j-1];
                }
                else{
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }
}