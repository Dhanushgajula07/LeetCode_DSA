class MinStack {
    Stack<Long> st;
    public MinStack() {
        st = new Stack<>();
    }
    Long min;
    public void push(int val) {
        if(st.isEmpty()){
            min = (long) val;
            st.push(min);
        }
        else{
            if(val < min){
                Long val1 = 2L * val - min;
                st.push(val1);
                min = (long) val;
            }
            else{
                st.push((long) val);
            }
        }
    }
    
    public void pop() {
        if(st.peek() < min){
            min = 2L * min - st.peek();
        }
        st.pop();
    }
    
    public int top() {
        if(st.peek() < min){
            return min.intValue();
        }
        return st.peek().intValue();
    }
    
    public int getMin() {
        return min.intValue();
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