class Solution {
    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()) return false;
        if(s == null || t == null ) return true;
        if(s.length() == 0 && t.length() == 0) return true;

        HashMap<Character, Character> map = new HashMap<Character, Character>();

        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);

            if(!map.containsKey(a)){
                if(!map.containsValue(b)){
                    map.put(a,b);
                }else return false;
            }else {
                char c = map.get(a);
                if(c != b ) return false;
            }
        }

        return true;
        
    }
}