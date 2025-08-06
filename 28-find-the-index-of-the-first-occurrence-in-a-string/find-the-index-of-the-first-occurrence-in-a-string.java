// class Solution {
//     public int strStr(String main, String pattern) {
//         //so its the string matchging technique that can be aolved uisng 3 algorithms:
//         // 1. kmp
//         // 2. erbin karp
//         // 3. z algorithm
//         // lets go one by one

//         // 1. KMP
//         // we need to creeate the lps -> longest prefix suffix aray on patter then use that to compute fall back and do the work that can be done on O(m * n) in O(m + n) time

//         // get the lps
//         int[] lps = getLPS(pattern);

//         // now lets use that to get the 1st occurabnce
//         int i = 0;
//         int j = 0;
//         int n = main.length();
//         int m = pattern.length();

//         while (i < n) {
//             if (main.charAt(i) == pattern.charAt(j)) {
//                 i++;
//                 j++;
//             }

//             // match found
//             if (j == m) {
//                 return i -  m ;
//                 // j = lps[j-1]; // refresh found check others
//             } else if (i < n && main.charAt(i) != pattern.charAt(j)) {
//                 // try to fall back
//                 if (j != 0) {
//                     j = lps[j - 1];
//                 } else {
//                     i++;
//                 }
//             }
//         }
//         return -1;
//     }

//     public int[] getLPS(String pattern) {
//         int m = pattern.length();
//         int[] lps = new int[m];
//         lps[0] = 0;

//         int i = 1;
//         int len = 0;
//         while (i < m) {
//             // case 1: matched
//             if (pattern.charAt(i) == pattern.charAt(len)) {
//                 len++;
//                 lps[i] = len;
//                 i++;
//             }
//             // case 2: not matched
//             else {
//                 if (len != 0) { // len is capable for fall back
//                     len = lps[len - 1];
//                 } else {
//                     // not possible to fall back
//                     lps[i] = 0;
//                     i++;
//                 }
//             }
//         }
//         return lps;
//     }
// }

// 2. now lets use the rabin karp
// which uses the polynominal hashing function and rolling hashing techniques

// class Solution {
//     public int strStr(String main, String pattern) {
//         int mod = 101;
//         int base = 256;

//         int totalhash = 1;
//         int patternhash = 0;
//         int mainhash = 0;

//         int m = pattern.length();
//         int n = main.length();

//         // edge case: if pattern is longer than text
//         if (m > n)
//             return -1;

//         // phase: 1
//         // compute the total hash till m-1
//         for (int i = 0; i < m - 1; i++) {
//             totalhash = (base * totalhash) % mod;
//         }

//         // phase : 2
//         for (int i = 0; i < m; i++) {
//             patternhash = (patternhash * base + (int) pattern.charAt(i)) % mod;
//             mainhash = (mainhash * base + (int) main.charAt(i)) % mod;
//         }

//         // phase 3:
//         // rolling hashing and ans finding
//         for (int i = 0; i <= n - m; i++) { // Only go till n - m to avoid out-of-bounds error
//             if (patternhash == mainhash) {
//                 if (main.substring(i, i + m).equals(pattern)) {
//                     return i;
//                 }
//             }

//             if (i < n - m) {
//                 // now rolling
//                 mainhash = (base * ((mainhash - ((int) main.charAt(i) * totalhash) % mod + mod) % mod)
//                         + (int) main.charAt(i + m)) % mod;

//                 // Handle negative result after modulo
//                 if (mainhash < 0) {
//                     mainhash += mod;
//                 }
//             }
//         }
//         return -1;
//     }
// }

// in the previous algontheir was a bit change in the approach of the find the rolling hash

//3. now we will solve the z-function
// its the one thatr hold me back untill i watched yt video and understood

// we build a z tabkle of the combined string
class Solution {
    public int strStr(String main, String pattern) {
        if (pattern.isEmpty()) return 0;
        if (main.isEmpty()) return -1;

        String combined = pattern + '$' + main;
        int[] z = getZtable(combined);
        int m = pattern.length();
        int n = z.length;
        for (int i = m + 1; i < n; i++) {
            if (z[i] == m) {
                return i - m - 1;
            }
        }
        return -1;
    }

    public int[] getZtable(String text) {
        int n = text.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;
                while (r < n && text.charAt(r - l) == text.charAt(r)) {
                    r++;
                }
                z[i] = r - l;
                r--;
            } else {
                int k = i - l;
                if (z[k] < r - i + 1) {
                    z[i] = z[k];
                } else {
                    l = i;
                    while (r < n && text.charAt(r - l) == text.charAt(r)) {
                        r++;
                    }
                    z[i] = r - l;
                    r--;
                }
            }
        }
        return z;
    }
}