class Solution {
    public String longestPrefix(String s) {
        //         \U0001f527 Steps:

        // 1. Build the LPS array of the string s:
        // lps[i] = length of longest prefix which is also suffix for s[0...i]
        // 2. Let len = lps[s.length() - 1]
        // 3. Return: s.substring(0, len);

        // ⚠️ Note:
        // If len == 0, return "" (no happy prefix exists).

        int n = s.length();
        int[] lps = getLPS(s, n);

        // now lets return ans
        int len = lps[n - 1];

        if (len == 0)
            return "";

        return s.substring(0, len);
    }

    public int[] getLPS(String str, int n) {
        int[] lps = new int[n];

        // lets build it
        int j = 0;
        int i = 1;

        while (i < n) {
            // now str matched
            if (str.charAt(i) == str.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else if (i < n && str.charAt(i) != str.charAt(j)) {
                // now fall bask
                if (j != 0) {
                    // can fallback
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}