class Solution {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        
        // Helper method for backtracking
        backtrack(result, current, 0, 0, n);
        
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder current, int openCount, int closeCount, int max) {
        // Base case: If the current combination is complete
        if (openCount == max && closeCount == max) {
            result.add(current.toString());
            return;
        }

        // If we can add an open parenthesis
        if (openCount < max) {
            current.append('(');
            backtrack(result, current, openCount + 1, closeCount, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }

        // If we can add a close parenthesis
        if (closeCount < openCount) {
            current.append(')');
            backtrack(result, current, openCount, closeCount + 1, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}
