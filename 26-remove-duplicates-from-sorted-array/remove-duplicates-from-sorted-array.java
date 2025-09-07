public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1; // First element is always unique

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue; // Skip duplicate elements
            }

            nums[k] = nums[i]; // Place unique element
            k++;
        }

        return k;
    }
}
