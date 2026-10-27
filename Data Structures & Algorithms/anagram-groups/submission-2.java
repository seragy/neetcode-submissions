class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] sSort = strs[i].toCharArray();
            Arrays.sort(sSort);
            String sSorted = new String(sSort);

            if (map.containsKey(sSorted)) {
                map.get(sSorted).add(strs[i]);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(strs[i]);
                map.put(sSorted, tmp);
            }
        }

        return new ArrayList<>(map.values());
    }
}