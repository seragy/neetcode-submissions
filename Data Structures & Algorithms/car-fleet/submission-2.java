class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // pair up each car's position and speed
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // sort by position, closest to the start first
        Arrays.sort(cars, (a, b) -> a[0] - b[0]);

        // arrival time of each fleet
        Stack<Double> stack = new Stack<>();

        // go from the car closest to the target back to the farthest
        for (int i = n - 1; i >= 0; i--) {
            double time = (double) (target - cars[i][0]) / cars[i][1];

            // a new fleet only if it arrives later than the fleet ahead
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            // otherwise it catches up and joins that fleet
        }

        return stack.size();
    }
}