class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a map to group anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Convert the string to a char array and sort it
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            // Convert the sorted char array back to a string to use as a key
            String sortedKey = new String(charArray);
            
            // Add the original string to the corresponding group in the map
            map.putIfAbsent(sortedKey, new ArrayList<>());
            map.get(sortedKey).add(str);
        }
        
        // Return all the grouped anagrams as a list of lists
        return new ArrayList<>(map.values());
    }
}
