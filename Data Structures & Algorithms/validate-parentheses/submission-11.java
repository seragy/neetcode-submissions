class Solution {
    public boolean isValid(String s) {

        // closing bracket -> its opening bracket
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        // stores openers we haven't closed yet
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            // opener: push it
            if (!map.containsKey(c))
            {
                stack.push(c);
            }
            // closer: check it matches the last opener
            else
            {
                // nothing to match
                if (stack.isEmpty())
                {
                    return false;
                }

                char topElement = stack.pop();

                // wrong type of opener
                if (topElement != map.get(c))
                {
                    return false;
                }
            }
        }

        // all openers must be closed
        return stack.isEmpty();
    }
}