class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        int[] lps = buildLPS(needle);
        int i = 0; // pointer for haystack
        int j = 0; // pointer for needle

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == needle.length()) {
                    return i - j; // match found
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1]; // jump using LPS
                } else {
                    i++; // move haystack pointer
                }
            }
        }
        return -1;
    }

    private int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0; // length of previous longest prefix
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}



// class Solution {
//     public int strStr(String haystack, String needle) {

//         if (needle.length() == 0) return 0;
//         if (haystack.length() < needle.length()) return -1;

//         int n = haystack.length();
//         int m = needle.length();

//         // loop through haystack
//         for (int i = 0; i <= n - m; i++) {

//             // check only when first character matches
//             if (haystack.charAt(i) == needle.charAt(0)) {

//                 int j = 0;

//                 // check remaining characters
//                 while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
//                     j++;
//                 }

//                 // if all characters matched
//                 if (j == m) {
//                     return i;
//                 }
//             }
//         }

//         return -1;
//     }
// }
