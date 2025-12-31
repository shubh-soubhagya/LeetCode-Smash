class Solution {
    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;

        int n = haystack.length();
        int m = needle.length();

        // loop through haystack
        for (int i = 0; i <= n - m; i++) {

            // check only when first character matches
            if (haystack.charAt(i) == needle.charAt(0)) {

                int j = 0;

                // check remaining characters
                while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                    j++;
                }

                // if all characters matched
                if (j == m) {
                    return i;
                }
            }
        }

        return -1;
    }
}
