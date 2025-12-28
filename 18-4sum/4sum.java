import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        Set<List<Integer>> hashset = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);

                        if (!hashset.contains(temp)) {
                            hashset.add(temp);
                            result.add(temp);
                        }

                        k++;
                        l--;
                    }
                }
            }
        }

        return result;
    }
}
