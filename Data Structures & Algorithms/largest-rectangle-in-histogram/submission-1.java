class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        // each entry is {start index, height}
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int start = i;

            // the new bar is shorter than the top: the top can't stretch any further right
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                maxArea = Math.max(maxArea, top[1] * (i - top[0]));
                start = top[0];   // the new bar can stretch back as far as the popped bar could
            }

            stack.push(new int[]{start, heights[i]});
        }

        // bars left on the stack stretch all the way to the right end
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            maxArea = Math.max(maxArea, top[1] * (n - top[0]));
        }

        return maxArea;
    }
}