class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s==null || t==null) return false;
        if(s.length() != t.length()) return false;
        if(s.length()==0 && t.length()==0) return true;

        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i =0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(!map.containsKey(c1)){
                if(!map.containsValue(c2)){
                    map.put(c1,c2);
                }else{
                    return false;
                }
            }else {
                char mapchar = map.get(c1);
                if(mapchar != c2) return false;
            }
        }
        return true;
    }
}