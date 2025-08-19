class Solution {
    public int threeSumClosest(int[] a, int target) {
        int closestSum = 0;
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    int sum = a[i] + a[j] + a[k];
                    int currDiff = Math.abs(target - sum);

                    if (currDiff < diff) {
                        diff = currDiff;
                        closestSum = sum;
                    }
                }
            }
        }
        return closestSum;
    }
}
