class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // Pop the top two elements from the stack
                int b = stack.pop();
                int a = stack.pop();

                // Apply the operation and push the result
                if (token.equals("+")) {
                    stack.push(a + b);
                } else if (token.equals("-")) {
                    stack.push(a - b);
                } else if (token.equals("*")) {
                    stack.push(a * b);
                } else {
                    stack.push(a / b); // Division truncates toward zero
                }
            } else {
                // If it's a number, push it onto the stack
                stack.push(Integer.parseInt(token));
            }
        }

        // The result is the last element in the stack
        return stack.pop();
    }
}
