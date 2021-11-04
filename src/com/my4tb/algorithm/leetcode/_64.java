package com.my4tb.algorithm.leetcode;

public class _64 {

    private static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] f = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0)
                    f[j] = grid[i][j];
                else if (i == 0)
                    f[j] = f[j - 1] + grid[i][j];
                else if (j == 0)
                    f[j] += grid[i][j];
                else
                    f[j] = Math.min(f[j - 1], f[j]) + grid[i][j];
            }
        }

        return f[cols - 1];
    }

    public static void main(String[] args) {

    }

}
