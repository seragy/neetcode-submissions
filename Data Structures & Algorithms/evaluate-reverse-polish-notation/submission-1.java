class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<tokens.length; i++)
        {
            if(tokens[i].equals("+"))
            {
                int tmp2 = stack.pop();
                int tmp1 = stack.pop();
                int result = tmp1 + tmp2;
                stack.push(result);
            }
            else if(tokens[i].equals("-"))
            {
                int tmp2 = stack.pop();
                int tmp1 = stack.pop();
                int result = tmp1 - tmp2;
                stack.push(result);
            }
            else if(tokens[i].equals("*"))
            {
                int tmp2 = stack.pop();
                int tmp1 = stack.pop();
                int result = tmp1 * tmp2;
                stack.push(result);
            }
            else if(tokens[i].equals("/"))
            {
                int tmp2 = stack.pop();
                int tmp1 = stack.pop();
                int result = tmp1 / tmp2;
                stack.push(result);
            }
            else
            {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
