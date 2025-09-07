class Solution {
    public int thirdMax(int[] arr) {
        
        Long first = Long.MIN_VALUE;
        Long second = Long.MIN_VALUE;
        Long third = Long.MIN_VALUE;

        for (int val : arr) {
            // Skip duplicates
            if (val == first || val == second || val == third) continue;

            if (val > first) {
                third = second;
                second = first;
                first = (long) val;
            } else if (val > second) {
                third = second;
                second = (long) val;
            } else if (val > third) {
                third = (long) val;
            }
        }

        if (third == Long.MIN_VALUE) {
            return first.intValue();
        } else {
            return third.intValue();
        }
        
    }
}