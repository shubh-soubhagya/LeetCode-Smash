class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int result = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];   // expand window

            // shrink window while condition satisfied
            while (sum >= target) {
                result = Math.min(result, i - start + 1);
                sum -= nums[start];
                start++;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
