class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String cm = strs[0];
        for (int i = 1; i < strs.length && !cm.isEmpty(); i++) {
            String s = strs[i];
            int min = Math.min(s.length(), cm.length());
            int j = 0;
            while (j < min && s.charAt(j) == cm.charAt(j)) j++;
            cm = cm.substring(0, j);
        }
        return cm;
        }

}
