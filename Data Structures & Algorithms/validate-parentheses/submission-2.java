class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
            {
                stack.push(s.charAt(i));
            }
            else if(stack.empty())
            {
                return false;
            }
            else if(stack.peek() != map.get(s.charAt(i)))
            {
                return false;
            }
            else stack.pop();
        }

        return stack.empty();

    }
}
