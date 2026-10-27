class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int L = 0;
        int R = s.length()-1;

        while(L < R)
        {
            while (L < R && !Character.isLetterOrDigit(s.charAt(L))) L++;
            while (L < R && !Character.isLetterOrDigit(s.charAt(R))) R--;

            if(s.charAt(L) != s.charAt(R))
            {
                return false;
            }
            else
            {
                R--;
                L++;
            }
           
        }
        return true;
    }
}
