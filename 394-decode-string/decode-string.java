class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == ']') {
                // 1. get the substring inside [...]
                StringBuilder curr = new StringBuilder();

                while (!st.isEmpty() && st.peek() != '[') {
                    curr.append(st.pop());
                }

                curr.reverse(); // because popped in reverse order

                st.pop(); // remove '['

                // 2. get the number (may be multi-digit)
                StringBuilder numStr = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    numStr.append(st.pop());
                }

                numStr.reverse();
                int num = Integer.parseInt(numStr.toString());

                // 3. repeat the substring 'num' times and push back to stack
                String repeated = curr.toString().repeat(num);
                for (char ch : repeated.toCharArray()) {
                    st.push(ch);
                }

            } else {
                st.push(c); // normal push
            }
        }

        // 4. build final answer
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) ans.append(st.pop());

        return ans.reverse().toString();
    }
}
