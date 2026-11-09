class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;          // found it
            } else if (nums[mid] < target) {
                low = mid + 1;       // target is in the right half
            } else {
                high = mid - 1;      // target is in the left half
            }
        }

        return -1;                   // not in the array
    }
}