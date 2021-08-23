package com.my4tb.algorithm.lintcode;

public class _110 {

    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public static int minPathSum(int[][] grid) {
        // write your code here
        int m, n;
        if (grid == null || (m = grid.length) == 0 || (n = grid[0].length) == 0)
            return 0;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = grid[i][j];
                if (i != 0 || j != 0) {
                    if (i == 0)
                        f[i][j] += f[i][j - 1];
                    else if (j == 0)
                        f[i][j] += f[i - 1][j];
                    else
                        f[i][j] += Math.min(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }

}
