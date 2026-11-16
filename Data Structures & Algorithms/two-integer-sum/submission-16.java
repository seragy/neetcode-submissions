class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Create HashMap to store numbers and their indices
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for(int i=0; i<nums.length; i++)
        {
            //Calculate complement of the current number
            int complement = target - nums[i];

            // Check if the complement is already in the map
            if (map.containsKey(complement))
            {
                // If found, return the indices of the complement and the curent number
                return new int[] {map.get(complement), i};
            }
        // Otherwise, add the current number and its index to the map
            map.put(nums[i], i);
        }
        
        // Return empty array if no solution was found
        return new int[]{};

    }
}