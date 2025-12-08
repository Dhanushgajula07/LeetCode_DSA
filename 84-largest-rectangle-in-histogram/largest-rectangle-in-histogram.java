class Solution {
    public int largestRectangleArea(int[] heights) {
        // now lets solve it using single stack
        // MAH
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int ans = 0;
        for(int i = 0;i<=n;i++){
            int currHeight = (i == n) ? 0 : heights[i];
            while(!st.isEmpty() && heights[st.peek()]  >= currHeight){
                // mean i need to remove and down is nsl and curr is nsr
                int currIdx = st.pop();
                int val = st.isEmpty() ? i : i - st.peek() - 1;// -1 already done
                ans = Math.max(ans,val * heights[currIdx]);
            }
            st.push(i);
        }

        return ans;
    }
}