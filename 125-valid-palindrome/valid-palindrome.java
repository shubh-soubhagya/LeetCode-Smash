class Solution {
    public boolean isPalindrome(String s) {
        String withoutspace = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int left = 0;
        int right = withoutspace.length()-1;
        while(left<right){
            if(withoutspace.charAt(left)!=withoutspace.charAt(right)){
                return false;
            }
            left ++;
            right--;
        }
        return true;

    }
}