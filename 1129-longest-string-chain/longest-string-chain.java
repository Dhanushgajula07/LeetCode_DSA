class Solution {
    public int longestStrChain(String[] arr) {
        // so basically its LIS but here while chgecking > i should write a extra methos fior comparing the Strings
        // catchy pints are base case and skipped boolean
        int n = arr.length;
        int[] dp = new int[n];

        // fill with 1 because singel is also valid
        Arrays.fill(dp, 1);
        // their is catch we should sort to have correct answers
        // else we will get wrong answer
         Arrays.sort(arr,(a,b)->a.length()-b.length());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // check if arr[j] can be part
                // it basically say longest subsequence that ends at index i
                if (arr[i].length() == arr[j].length() + 1 && compare(arr[j], arr[i], 0, 0)) {
                    // can be part
                    dp[i] =  Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int max = Arrays.stream(dp).max().getAsInt();

        return max;
    }

    public boolean compare(String s, String t, int i, int j) {
         if (t.length() != s.length() + 1) return false;

        boolean skipped = false;
       while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                if (skipped) return false;
                skipped = true;
                j++; // skip one char from t
            }
        }

        return true;
    }
}