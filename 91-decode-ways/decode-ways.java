public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return decodeHelper(s, 0,memo);
    }

    private int decodeHelper(String s, int index,int[] memo) {
        // Base case: reached end successfully
        if (index == s.length()) {
            return 1;
        }

        // If current char is '0', no decoding possible
        if (s.charAt(index) == '0') {
            return 0;
        }

        if(memo[index] != -1){
            return memo[index];
        }
        // Pick single digit
        int ways = decodeHelper(s, index + 1,memo);

        // Pick two digits if possible
        if (index + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigit <= 26) {
                ways += decodeHelper(s, index + 2,memo);
            }
        }
        memo[index] = ways;
        return ways;
    }
}
