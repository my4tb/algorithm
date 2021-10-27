package com.my4tb.algorithm.lintcode;

import java.util.Arrays;

/**
 * 考虑最后一步：最优状态下，正方形右下角的格子坐标为(i, j)，边长为L
 * 那么以(i-1, j-1)、(i-1, j)和(i, j-1)为右下角正方形的边长为L-1
 * <p>
 * f[i][j]表示以坐标(i, j)为右下角的最大全1正方形的最大边长
 */
public class _436 {

    private static int maxSquare(int[][] matrix) {
        // write your code here
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        int[][] f = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    if (matrix[i][j] == 1)
                        f[i][j] = 1;
                } else if (matrix[i][j] == 1) {
                    f[i][j] = min(f[i - 1][j - 1], f[i][j - 1], f[i - 1][j]) + 1;
                }
                max = Math.max(max, f[i][j]);
            }
        }

        for (int i = 0; i < row; i++)
            System.out.println(Arrays.toString(f[i]));

        return max * max;
    }

    private static int min(int a, int b, int c) {
        if (b < a)
            a = b;
        if (c < a)
            a = c;
        return a;
    }

    public static void main(String[] args) {

    }

}
