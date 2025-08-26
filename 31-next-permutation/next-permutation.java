import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find the first decreasing number from the right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If we found a number, find the next larger number on the right
        if (i >= 0) {
            int j = n - 1;
            // Find a number larger than nums[i]
            while (nums[j] <= nums[i]) {
                j--;
            }

            // Swap nums[i] and nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // Step 3: Reverse the numbers to the right of i to get the next permutation
        int start = i + 1;
        int end = n - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
