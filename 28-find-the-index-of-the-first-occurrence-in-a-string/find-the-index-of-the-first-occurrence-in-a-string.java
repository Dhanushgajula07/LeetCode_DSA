class Solution {
    public int strStr(String main, String pattern) {
        //so its the string matchging technique that can be aolved uisng 3 algorithms:
        // 1. kmp
        // 2. erbin karp
        // 3. z algorithm
        // lets go one by one

        // 1. KMP
        // we need to creeate the lps -> longest prefix suffix aray on patter then use that to compute fall back and do the work that can be done on O(m * n) in O(m + n) time

        // get the lps
        int[] lps = getLPS(pattern);

        // now lets use that to get the 1st occurabnce
        int i = 0;
        int j = 0;
        int n = main.length();
        int m = pattern.length();

        while (i < n) {
            if (main.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            // match found
            if (j == m) {
                return i - m ;
                // j = lps[j-1]; // refresh found check others
            } else if (i < n && main.charAt(i) != pattern.charAt(j)) {
                // try to fall back
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    public int[] getLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        lps[0] = 0;

        int i = 1;
        int len = 0;
        while (i < m) {
            // case 1: matched
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            // case 2: not matched
            else {
                if (len != 0) { // len is capable for fall back
                    len = lps[len - 1];
                } else {
                    // not possible to fall back
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}