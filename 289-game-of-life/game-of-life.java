class Solution {
    public void gameOfLife(int[][] a) {
        int m = a.length;
        int n = a[0].length;

        // Make a copy of the board so we don't overwrite while counting
        int[][] copy = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = a[i][j];
            }
        }

        // For each cell, count live neighbors
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;

                // check 8 neighbors
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x == i && y == j) continue; // skip itself
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            if (copy[x][y] == 1) {
                                count++;
                            }
                        }
                    }
                }

                // Apply rules
                if (copy[i][j] == 1 && count < 2) {
                    a[i][j] = 0; // Rule 1: underpopulation
                } else if (copy[i][j] == 1 && (count == 2 || count == 3)) {
                    a[i][j] = 1; // Rule 2: lives on
                } else if (copy[i][j] == 1 && count > 3) {
                    a[i][j] = 0; // Rule 3: overpopulation
                } else if (copy[i][j] == 0 && count == 3) {
                    a[i][j] = 1; // Rule 4: reproduction
                } else {
                    a[i][j] = 0; // stays dead
                }
            }
        }
    }
}
