class MinStack {

    Stack<int[]> st;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(new int[] { val, val });
        } else {
           int currMin = Math.min(val, st.peek()[1]);
            st.push(new int[] { val, currMin });
        }
    }

    public void pop() {
        st.pop();
        // if (!st.isEmpty()) {
        //     currMin = st.peek()[1];
        // } else {
        //     min = Integer.MAX_VALUE;
        // }
    }

    public int top() {
        int[] top = st.peek();
        return top[0];
    }

    public int getMin() {
        int[] min = st.peek();
        return min[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */