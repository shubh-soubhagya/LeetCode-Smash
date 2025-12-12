class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];  // value
            arr[i][1] = i;        // original index
        }

        java.util.Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = arr[left][0] + arr[right][0];

            if (sum == target) {
                return new int[]{arr[left][1], arr[right][1]};
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[0];
    }
}
