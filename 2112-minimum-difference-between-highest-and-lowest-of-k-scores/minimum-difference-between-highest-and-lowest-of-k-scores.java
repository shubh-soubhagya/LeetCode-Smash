class Solution {
    public int minimumDifference(int[] nums, int k) {
        int mindiff = Integer.MAX_VALUE;

        Arrays.sort(nums);
        for(int i = 0; i<=nums.length -k; i++){
            int diff = nums[i+k-1] - nums[i];
            mindiff = Math.min(mindiff, diff);
        }

        return mindiff;

    }
}