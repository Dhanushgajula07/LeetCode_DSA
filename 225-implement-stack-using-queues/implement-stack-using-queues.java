class MyStack {
    Queue<Integer> q1;

    public MyStack() {
        q1 = new LinkedList<>();
        
    }
    
    public void push(int x) {
        // so for push i can add that to q2 and add all the ele from q1 to q2 and then swap
        q1.add(x);
        int sz = q1.size();
        while(sz > 1){
            q1.add(q1.poll());
            sz--;
        }       
    }
    
    public int pop() {
         // put all
         return q1.poll();
    }
    
    public int top() {
        
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */