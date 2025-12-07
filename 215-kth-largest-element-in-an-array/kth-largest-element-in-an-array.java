import java.util.*;

class Solution {
    Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        return quickSelect(list, k);
    }

    private int quickSelect(List<Integer> nums, int k) {
        if (nums.isEmpty()) return -1;

        int pivot = nums.get(rand.nextInt(nums.size()));

        List<Integer> left = new ArrayList<>();   // nums > pivot
        List<Integer> mid  = new ArrayList<>();   // nums == pivot
        List<Integer> right = new ArrayList<>();  // nums < pivot

        for (int num : nums) {
            if (num > pivot) left.add(num);
            else if (num < pivot) right.add(num);
            else mid.add(num);
        }

        int L = left.size();
        int M = mid.size();

        if (k <= L) {
            return quickSelect(left, k);
        } else if (k > L + M) {
            return quickSelect(right, k - L - M);
        } else {
            return pivot;
        }
    }
}
