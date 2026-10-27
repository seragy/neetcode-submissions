
class Solution {
    public boolean isAnagram(String s, String t) {

        // Check if the lengths are different
        if (s.length() != t.length()) {
            return false;
        }

        // Convert strings to character arrays
        char[] newS = s.toCharArray();
        char[] newT = t.toCharArray();

        // Sort the character arrays
        Arrays.sort(newS);
        Arrays.sort(newT);

        // Compare sorted arrays
        return Arrays.equals(newS,newT);
    }
}
