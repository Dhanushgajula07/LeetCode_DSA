class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int x : asteroids) {
            if (st.isEmpty()) {
                st.push(x);
                continue;
            }

            // they collide ONLY if: previous > 0 and current < 0
            if (st.peek() > 0 && x < 0) {

                boolean pushCurrent = true;

                while (!st.isEmpty() && st.peek() > 0 && x < 0) {
                    int top = st.peek();

                    if (top < -x) {
                        st.pop();       // top dies → continue collision
                    } else if (top == -x) {
                        st.pop();       // both die
                        pushCurrent = false;
                        break;
                    } else {           
                        // current dies
                        pushCurrent = false;
                        break;
                    }
                }

                if (pushCurrent) st.push(x);
            }
            else {
                // No collision, safe to push
                st.push(x);
            }
        }

        int[] ans = new int[st.size()];
        int i = 0;
        for (int val : st) ans[i++] = val;
        return ans;
    }
}
