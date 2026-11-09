class Solution {
    public boolean isAnagram(String s, String t) {

        // Check if lengths are the same
        if (s.length() != t.length()) {
            return false;
        }

        //Create an array of size 26 "size of alphabets"
        int[] charCounts = new int[26];

        //Loop in array, increment if using String s, decrement if using String t
        for(int i=0; i<s.length(); i++)
        {
            charCounts[s.charAt(i) - 'a'] ++;
            charCounts[t.charAt(i) - 'a'] --;
        }

        //If all values in array created not = 0 then it is not an anagram
        for(int count : charCounts)
        {
            if (count != 0)
            {
                return false;
            }
        }

        return true; //ANAGRAM
    }

}