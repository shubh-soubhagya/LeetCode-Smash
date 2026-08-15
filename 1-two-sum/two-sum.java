class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Store value and original index
        int[][] arr = new int[nums.length][2];

        for (int k = 0; k < nums.length; k++) {
            arr[k][0] = nums[k];
            arr[k][1] = k;
        }

        // Sort by value
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int i = 0;                  // Left pointer
        int j = nums.length - 1;    // Right pointer

        while (i < j) {

            int sum = arr[i][0] + arr[j][0];

            if (sum == target) {
                // Return original indices
                return new int[]{arr[i][1], arr[j][1]};
            }
            else if (sum < target) {
                // Need a bigger sum
                i++;
            }
            else {
                // Need a smaller sum
                j--;
            }
        }

        return new int[]{};
    }
}