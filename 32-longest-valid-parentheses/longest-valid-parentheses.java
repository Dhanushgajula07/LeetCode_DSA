import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1); // base for the first valid substring

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i); // push index of '('
            } else {
                st.pop(); // try to match ')'

                if (st.isEmpty()) {
                    st.push(i); // unmatched ')', new base
                } else {
                    maxLen = Math.max(maxLen, i - st.peek());
                }
            }
        }

        return maxLen;
    }
}
