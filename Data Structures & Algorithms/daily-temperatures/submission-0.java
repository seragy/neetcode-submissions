class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // While stack is not empty and current temperature is warmer
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop(); // Get the index of the previous day
                result[prevIndex] = i - prevIndex; // Calculate the days difference
            }
            stack.push(i); // Push current index onto the stack
        }
        
        return result;
    }
}
