class MinStack {
    Stack<Long> st;
    long min;
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(st.size() == 0){
            st.push(0L);
            min = val;
        }else{
            long gap = val - min;
        st.push(gap);
        }
        
        if(val < min){
            min = val;
        } 

    }
    
    public void pop() {
        if (st.isEmpty()) return;

        long rem = st.pop();
        if(rem < 0 ){
            // long val = min;
            min = min - rem;
        }
        else{
            // long val = min + rem;
        }
    }
    
    public int top() {
        if (st.isEmpty()) return -1;

        long rem = st.peek();
        if(rem < 0){
            return (int)min;
        }
        else{
            long val = rem + min;
            return (int)val;
        }
    }
    
    public int getMin() {
        if(st.size() == 0){
            return -1;
        }
        else{
            return (int)min;
        }
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