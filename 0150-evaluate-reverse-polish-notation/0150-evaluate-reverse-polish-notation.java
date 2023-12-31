class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++) stack.push(tokens[i]);
        return calculate(stack);
    }

    private int calculate(Stack<String> stack) {
        String cur = stack.pop();
        int a = 0,b = 0;
        if("+-*/".contains(cur)) {
            b = calculate(stack);
            a = calculate(stack);
        } else {
            return Integer.parseInt(cur);
        }
        switch(cur.charAt(0)) {
            case '+': 
                return a + b;
            case '-': 
                return a - b;
            case '*': 
                return a * b;
            case '/': 
                return a / b;
        }
        return 0;
    }
}