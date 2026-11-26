class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int left = 0;
        int right = 0;
        int ans = 0;

        // tracks characters currently in the window
        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);

            // duplicate found — shrink from the left until it's removed
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // add current character to window
            set.add(c);

            // update longest substring found so far
            ans = Math.max(ans, right - left + 1);

            right++;
        }

        return ans;
    }
}
