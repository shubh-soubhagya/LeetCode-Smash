class Solution {
    public int[] productExceptSelf(int[] a) {
        int n = a.length;
        int[] result = new int[n];
        int totalProduct = 1;
        int zeroCount = 0;

        // Step 1: Count zeros and calculate product of all non-zero elements
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                zeroCount++;
            } else {
                totalProduct = totalProduct * a[i];
            }
        }

        // Step 2: Build result based on zero count
        for (int i = 0; i < n; i++) {
            if (zeroCount > 1) {
                result[i] = 0; // More than 1 zero means all results are 0
            } else if (zeroCount == 1) {
                // Only the zero index gets the product
                if (a[i] == 0) {
                    result[i] = totalProduct;
                } 
            } else {
                // No zero in input → divide total product by current element
                result[i] = totalProduct / a[i];
            }
        }

        return result;
    }
}
