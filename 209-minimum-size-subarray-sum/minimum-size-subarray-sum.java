class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0; int sum = 0;
        int minlen = Integer.MAX_VALUE;

        for(int right = 0; right < n; right ++){
            sum = sum + nums[right];

            while(sum>= target){
                minlen = Math.min(minlen, right - left +1 );
                sum = sum - nums[left];
                left++;
            }
            
        }

        if (minlen == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minlen;
        }

    }
}