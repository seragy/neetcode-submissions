class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int left = 0;
        int right = sorted.length - 1;
        int v1 = 0;
        int v2 = 0;

        while (left < right) {
            int sum = sorted[left] + sorted[right];
            if (sum == target) {
                v1 = sorted[left];
                v2 = sorted[right];
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        int idx1 = -1;
        int idx2 = -1;

        for (int i = 0; i < nums.length; i++) {
            if (idx1 == -1 && nums[i] == v1) {
                idx1 = i;
            } else if (idx2 == -1 && nums[i] == v2) {
                idx2 = i;
            }
        }

        return new int[]{Math.min(idx1, idx2), Math.max(idx1, idx2)};
    }
}