class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int val2 = st.pop();
                int val1 = st.pop();
                int cal = calculate(val1, val2, token);
                st.push(cal);
            } else {
                st.push(Integer.parseInt(token)); // Convert string to integer
            }
        }

        return st.pop();
    }

    public int calculate(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; // Integer division truncates towards zero
            default: throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}