class Solution {
    public int mySqrt(int x) {

        int i=0;
        int j = x;

        while(i<=j){
            int mid = (j-i)/2 +i;
            if((long)((long)mid*(long)mid)==x)return mid;
            else if((long)((long)mid*(long)mid)>x) j= mid-1;
            else i=mid+1;
        }
        return j;
        
    }
}