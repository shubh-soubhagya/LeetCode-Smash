class Solution {
    public void merge(int[] A, int m, int[] B, int n) {

        int i = m - 1;        // last real element in A
        int j = n - 1;        // last element in B
        int k = m + n - 1;    // last position in A

        // while both arrays still have elements
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[k] = A[i];
                i--;
            } else {
                A[k] = B[j];
                j--;
            }
            k--;
        }

        // if anything left in B, copy it
        while (j >= 0) {
            A[k] = B[j];
            j--;
            k--;
        }
    }
}
