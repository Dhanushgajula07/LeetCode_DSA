import java.util.*;

class Solution {
    public int minCost(String colors, int[] neededTime) {
        Stack<int[]> st = new Stack<>();
        st.push(new int[]{colors.charAt(0), neededTime[0]});
        int minTime = 0;
        int n = neededTime.length;

        for (int i = 1; i < n; i++) {
            int color = colors.charAt(i);
            int time = neededTime[i];

            // If same color as top, remove one
            if (!st.isEmpty() && color == st.peek()[0]) {
                // Add the smaller time to total cost
                if (st.peek()[1] > time) {
                    minTime += time; // remove current (cheaper)
                } else {
                    minTime += st.pop()[1]; // remove previous (cheaper)
                    st.push(new int[]{color, time}); // keep current (more expensive)
                }
            } else {
                // different color, just push
                st.push(new int[]{color, time});
            }
        }

        return minTime;
    }
}
