class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // if k equals array length, all elements are needed
        if (k == nums.length) {
            return nums;
        }

        // count frequency of each number
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        // min-heap ordered by frequency — least frequent element stays at top
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));

        // add each unique number to the heap, evict least frequent if size exceeds k
        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll(); // remove least frequent
            }
        }

        // build result from remaining k elements in heap
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }

        return ans;
    }
}