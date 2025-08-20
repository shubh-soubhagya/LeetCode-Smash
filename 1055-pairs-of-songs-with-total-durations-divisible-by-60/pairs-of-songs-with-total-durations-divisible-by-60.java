class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int res = 0;

        for (int t : time) {
            int rem = t % 60;
            int complement = (60 - rem) % 60;
            res = res + count[complement];
            count[rem]++;
        }

        return res;
    }
}
