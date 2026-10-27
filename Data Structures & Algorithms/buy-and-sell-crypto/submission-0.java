class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE; // Track minimum price
        int maxProfit = 0;           // Track maximum profit

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i]; // Update the minimum price
            } else {
                // Calculate the profit if sold on the current day
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
        }

        return maxProfit;
    }
}
