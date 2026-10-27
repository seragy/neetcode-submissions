class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<nums.length; i++)
        {
        freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys, (a, b) -> freq.get(b) - freq.get(a));

        int[] res = new int[k];
        for(int i=0; i<k; i++)
        {
         res[i] = keys.get(i);
        }

        return res;

    }
}
