class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0]; int cmax = nums[0]; int cmin = nums[0];
        for(int i = 1; i<nums.length ; i++){
            if(nums[i]<0){
                int temp = cmax;
                cmax = cmin;
                cmin = temp;
            }
            cmax = Math.max(nums[i], nums[i] * cmax);
            cmin = Math.min(nums[i], nums[i] * cmin);
            max = Math.max(max, cmax);
        }
        return max;
    }
}