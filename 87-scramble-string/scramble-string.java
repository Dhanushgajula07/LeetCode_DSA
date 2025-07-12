class Solution {
    public boolean isScramble(String s1, String s2) {
        // so basically as aditya varma bro said its the question that needs tabulation for sure
        // and also its the question that takes lot of time in understanding the question than the answer it self
        // basically we should form a binary tree from that string and make sure that no subtree has only 1 child it must have both the childs
        // and we can swaap the sub trees nodes 
        // lets take an example 
        // great
        // gr | eat
        // g | r --> e | at
        //                 a | t
        // now we can see that its a perfect binary tree wher eeach parnt has exactly 2 child or none

        // and that can be swapped to form a rgeat so its a true

        // now you understood problem statment lets identify the pattern
        // we are actually splittinf at every index and decide what to do with left part and right part 
        // which is MCM matrix chain multiplication
        // i = 0,j=n-1 and k = i + 1 to j - 1 because i need at least one child for left and right

        // so now they asked for true or false
        // so there will be 2 possible ways
        // gr | eat ---> gr | eat. : nothing to actually swap but still can be compare with s1(0 to i) with s2(0 to i) and s1(i to n) and s2(i to n)
        // else gr | eat ---> eat | gr now you got the pattern right we compare 1st part with the last part of str 2

        // so at every split i have a choice of comparing either front or back

        // i have 2 cases caseI and caseII

        // base cases
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals("") && s2.equals("")) {
            return true; // empty strings are also true
        }

        // if not anagram, we can return false early
        if (!anagram(s1.toCharArray(), s2.toCharArray())) {
            return false;
        }
        // now the actula game of mmeo
        HashMap<String,Boolean> memo = new HashMap<>();
        // now the actual code
        return solve(s1, s2,memo);
    }

    public boolean solve(String s1, String s2,HashMap<String,Boolean> memo) {
        // base case
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() <= 1) {
            return false;
        }
        String key = s1 + "*" + s2;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int n = s1.length();

        Boolean flag = false;
        for (int i = 1; i < n; i++) {
            // caseI: swap the parts
            boolean caseI = solve(s1.substring(0, i), s2.substring(n - i),memo) &&
                            solve(s1.substring(i), s2.substring(0, n - i),memo);

            // caseII: don't swap
            boolean caseII = solve(s1.substring(0, i), s2.substring(0, i),memo) &&
                             solve(s1.substring(i), s2.substring(i),memo);

            // if any one case gives true, return true
            if (caseI || caseII) {
                flag = true;
                break;
            }
        }

        memo.put(key,flag);

        return flag;
    }

    public boolean anagram(char[] s1, char[] s2) {
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2); // ✅ Arrays.equals, not ==
    }
}
