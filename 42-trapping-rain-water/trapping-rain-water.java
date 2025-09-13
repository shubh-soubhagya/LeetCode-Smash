class Solution {
    public int trap(int[] height) {

        if (height == null || height.length < 3) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update left max
                } else {
                    trappedWater += leftMax - height[left]; // Water trapped at left
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update right max
                } else {
                    trappedWater += rightMax - height[right]; // Water trapped at right
                }
                right--;
            }
        }
        return trappedWater;
        
    }
}