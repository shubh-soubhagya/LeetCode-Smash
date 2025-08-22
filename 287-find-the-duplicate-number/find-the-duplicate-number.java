class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1; // because numbers are in [1, n]

        while (low < high) {
            int mid = (low + high) / 2;

            // Count how many numbers are <= mid
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }

            // If too many numbers are <= mid, duplicate is in [low..mid]
            if (count > mid) {
                high = mid;
            } else {
                // Otherwise, it's in [mid+1..high]
                low = mid + 1;
            }
        }

        // When low == high, that's our duplicate
        return low;
    }
}
