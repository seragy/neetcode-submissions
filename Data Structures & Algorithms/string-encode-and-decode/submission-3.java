class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length());   // the length
            sb.append("#");            // marker: the length ends here
            sb.append(str);            // the string itself
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = str.indexOf('#', i);                      // end of the number
            int len = Integer.parseInt(str.substring(i, j));  // the length

            int start = j + 1;                                // word starts after '#'
            int end = start + len;                            // word ends after len chars

            result.add(str.substring(start, end));            // cut out the word
            i = end;                                          // next number starts here
        }

        return result;
    }
}