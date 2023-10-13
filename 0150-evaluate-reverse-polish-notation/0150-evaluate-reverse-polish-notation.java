class Solution {

    Stack<String> stack = new Stack<>();

    public int evalRPN(String[] tokens) {
        for(int i = 0; i < tokens.length; i++) stack.push(tokens[i]);

        return calculate();
    }

    private int calculate() {
        if(stack.isEmpty()) return -1;
        String cur = stack.pop();
        int a = 0,b = 0;
        if(cur.length() == 1 && (cur.charAt(0) == '+' || cur.charAt(0) == '-' || cur.charAt(0) == '*' || cur.charAt(0) == '/')) {
            b = calculate();
            a = calculate();
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