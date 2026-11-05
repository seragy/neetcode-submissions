class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<tokens.length; i++)
        {
            if(tokens[i].equals("+"))
            {
                int tmp1 = stack.pop();
                int tmp2 = stack.pop();
                int res = tmp1 + tmp2;
                stack.push(res);
            }
            else if(tokens[i].equals("-"))
            {
                int tmp1 = stack.pop();
                int tmp2 = stack.pop();
                int res = tmp2 - tmp1;
                stack.push(res);
            }
            else if(tokens[i].equals("*"))
            {
                int tmp1 = stack.pop();
                int tmp2 = stack.pop();
                int res = tmp1 * tmp2;
                stack.push(res);
            }
            else if(tokens[i].equals("/"))
            {
                int tmp1 = stack.pop();
                int tmp2 = stack.pop();
                int res = tmp2 / tmp1;
                stack.push(res);
            }
            else
            {
                int val = Integer.parseInt(tokens[i]);
                stack.push(val);
            }
        }
        return stack.peek();
    }
}
