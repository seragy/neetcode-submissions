class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        // holds indexes of days still waiting for a warmer day
        Stack<Integer> stack = new Stack<>();

        // answer for each day (0 by default)
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            // today is warmer than the waiting day on top
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();

                // days waited = today - that day
                result[prev] = i - prev;
            }

            // today now waits for a warmer day
            stack.push(i);
        }

        return result;
    }
}