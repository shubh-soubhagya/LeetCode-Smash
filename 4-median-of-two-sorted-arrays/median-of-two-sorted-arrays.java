class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int total = m + n;

        if (total % 2 != 0) {
            return findkth(a, b, total/2, 0, m-1, 0, n-1);
        } else {
            return (findkth(a, b, total/2 - 1, 0, m-1, 0, n-1)
                  + findkth(a, b, total/2,     0, m-1, 0, n-1)) / 2.0;
        }
    }

    public static int findkth(int A[], int B[], int k,
                              int astart, int aend,
                              int bstart, int bend) {

        int alen = aend - astart + 1;
        int blen = bend - bstart + 1;

        if (alen == 0) return B[bstart + k];
        if (blen == 0) return A[astart + k];

        if (k == 0) return Math.min(A[astart], B[bstart]);

        int amid = alen * k / (alen + blen);
        int bmid = k - amid - 1;

        amid += astart;
        bmid += bstart;

        if (A[amid] > B[bmid]) {
            return findkth(A, B, k - (bmid - bstart + 1),
                           astart, amid,
                           bmid + 1, bend);
        } else {
            return findkth(A, B, k - (amid - astart + 1),
                           amid + 1, aend,
                           bstart, bmid);
        }
    }
}
