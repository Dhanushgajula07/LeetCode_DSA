class FreqStack {
    HashMap<Integer,Integer> freq;
    HashMap<Integer,Stack<Integer>> group;
    int maxFreq = 0;
    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
    }
    
    public void push(int val) {
        freq.put(val,freq.getOrDefault(val,0) + 1);
        if(freq.get(val) > maxFreq){
            maxFreq = freq.get(val);
        }
        if(group.get(freq.get(val)) == null){ // not exist
            // then add
            group.put(freq.get(val),new Stack<>());
        }
        group.get(freq.get(val)).push(val);
    }
    
    public int pop() {
        int val = group.get(maxFreq).pop();
        freq.put(val,freq.get(val) - 1);
        if(group.get(maxFreq).isEmpty()){
            maxFreq--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */