class Solution {
    public int maxSubArray(int[] nums) {

        int maxSum = nums[0]; int Curr = nums[0];
        for(int i =1; i<nums.length; i++){
            Curr = Math.max(nums[i], Curr + nums[i]);
            maxSum = Math.max(maxSum, Curr);
        }
        return maxSum;
    }
}