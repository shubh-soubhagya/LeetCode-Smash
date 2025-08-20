import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;

        Arrays.sort(nums); // Step 1: Sort array

        int n = nums.length;

        // Step 2: First loop for first number
        for (int i = 0; i < n - 3; i++) {
            // Avoid duplicate for first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Step 3: Second loop for second number
            for (int j = i + 1; j < n - 2; j++) {
                // Avoid duplicate for second number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                // Step 4: Two-pointer search for remaining two numbers
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Move pointers
                        left++;
                        right--;

                        // Skip duplicates
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;

                    } else if (sum < target) {
                        left++; // need bigger sum
                    } else {
                        right--; // need smaller sum
                    }
                }
            }
        }
        return res;
    }
}
