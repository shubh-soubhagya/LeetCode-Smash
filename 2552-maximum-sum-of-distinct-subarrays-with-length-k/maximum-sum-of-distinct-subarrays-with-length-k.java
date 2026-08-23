class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;
        long sum = 0;
        long max = 0;

        for (int j = 0; j < nums.length; j++) {

            // Add current element
            sum = sum + nums[j];

            // Store frequency
            if (map.containsKey(nums[j])) {
                map.put(nums[j], map.get(nums[j]) + 1);
            } else {
                map.put(nums[j], 1);
            }

            // Window size becomes k
            if (j - i + 1 == k) {

                // All elements are distinct
                if (map.size() == k) {
                    max = Math.max(max, sum);
                }

                // Remove left element
                sum = sum - nums[i];

                map.put(nums[i], map.get(nums[i]) - 1);

                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }
        }

        return max;
    }
}