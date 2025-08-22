class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Detect cycle
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entry point of cycle (the duplicate number)
        return findEntry(nums, nums[0], slow);
    }

    // Recursive function to find entry point
    private int findEntry(int[] nums, int ptr1, int ptr2) {
        if (ptr1 == ptr2) {
            return ptr1;  // duplicate found
        }
        return findEntry(nums, nums[ptr1], nums[ptr2]);  // move both pointers one step
    }
}
