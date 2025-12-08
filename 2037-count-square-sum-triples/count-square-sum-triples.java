class Solution {
    public int countTriples(int n) {
        // Precompute perfect squares up to n*n
        boolean[] square = new boolean[n * n + 1];
        for (int i = 1; i <= n; i++) {
            square[i * i] = true;
        }

        int count = 0;

        // Try all a and b
        for (int a = 1; a <= n; a++) {
            int aa = a * a;
            for (int b = 1; b <= n; b++) {
                int sum = aa + b * b;

                // Check if result is perfect square within range
                if (sum <= n * n && square[sum]) {
                    count++;
                }
            }
        }

        return count;
    }
}
