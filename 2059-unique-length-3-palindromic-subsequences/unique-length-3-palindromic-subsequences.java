// import java.util.*;

// class Solution {
//     public int countPalindromicSubsequence(String s) {
//         int n = s.length();
//         Set<String> uniquePalindromes = new HashSet<>();
        
//         // Generate all subsequences of length 3
//         for (int i = 0; i < n - 2; i++) {
//             for (int j = i + 1; j < n - 1; j++) {
//                 for (int k = j + 1; k < n; k++) {
//                     // Form the subsequence
//                     String subsequence = "" + s.charAt(i) + s.charAt(j) + s.charAt(k);
                    
//                     // Check if it's a palindrome
//                     if (isPalindrome(subsequence)) {
//                         uniquePalindromes.add(subsequence);
//                     }
//                 }
//             }
//         }
        
//         // Return the number of unique palindromic subsequences
//         return uniquePalindromes.size();
//     }
    
//     // Helper function to check if a string is a palindrome
//     private boolean isPalindrome(String s) {
//         return s.charAt(0) == s.charAt(2);
//     }
// }

class Solution {
    public int countPalindromicSubsequence(String s) {
        int res = 0;
        for(char c = 'a'; c <= 'z'; c++) {
            int first = s.indexOf(c);
            int last = s.lastIndexOf(c);

            // if the char exists in the str and they're separated in a valid range
            if(first != -1 && last != -1 && first < last) {
                HashSet<Character> set = new HashSet<>();
                for(int i = first+1; i< last; i++) { // add unqiue chars in this range into set
                    set.add(s.charAt(i));
                }

                res += set.size(); // add contents of set into our res, ex if we found abc in btwn 1st & last a chars for "a abc a", that means we can create 3 diff palindromes

            }
        }

        return res;
    }
}