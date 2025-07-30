class Solution {
    public int strStr(String main, String pattern) {
        // so its a string matching algorithm
        /// brute force is O(m.n)
        // we will optimise it by KMP

        // kmp has 2 main methods :
        // 1. find the pi array
        // 2. now use it and find the index

        // pi array
        int[] pi = piarray(pattern);
        int ans = -1;
        // now you got pi and 2 strings now do matching

        int i= 0;
        int j = 0;
        int m = pattern.length();
        int n = main.length();

        while(i<n){
            // if matched
            if(main.charAt(i) == pattern.charAt(j)){
                // now matched so just i++ and j++
                i++;
                j++;
            }

            if(j == m){
                // answer found;
                ans = i - j;
               break;
            }
            else if(i<n && main.charAt(i) != pattern.charAt(j)){
                if(j != 0){
                    j = pi[j-1];
                }
                else{
                    i++;
                }
            }
        }

        return ans;
    }
    public int[] piarray(String pattern){
        int [] pi = new int[pattern.length()];
        int j=0;
        int i =1;
        int m = pattern.length();
        while(i<m){
            // chekc same?
            if(pattern.charAt(i) == pattern.charAt(j)){
                // matched so just fill pi with j + 1
                j++;
                pi[i] = j;
                i++;
            }
            else{
                // now go back but how many ?
                // exactly the length of the pref == suff
                if(j != 0){
                    j = pi[j-1];
                }
                else{
                    pi[j] = 0;
                    i++;
                }
            }
        }
        return pi;
    }
}