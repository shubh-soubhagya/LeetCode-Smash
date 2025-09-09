class Solution {
    public String removeOccurrences(String s, String part) {

        while (s.contains(part)) {   // keep removing until no "part" is left
            s = s.replaceFirst(part, ""); 
        }
        return s;
        
    }
}