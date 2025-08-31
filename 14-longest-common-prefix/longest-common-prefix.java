class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String cm = strs[0]; 

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            int temp=0;
            for(int j=0; j<Math.min(strs[i].length(), cm.length());j++){
                if(s.charAt(j)!= cm.charAt(j)){
                    cm = s.substring(0,j);
                    temp = 1;
                    break;
                }
            }

            if(temp==0) cm=strs[i].length()<cm.length()?strs[i]:cm;
        }
        return cm;
    }
}
