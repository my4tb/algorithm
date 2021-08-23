package com.my4tb.algorithm.lintcode;

public class _114 {

    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public static int uniquePaths(int m, int n) {
        // write your code here
        if (m <= 0 || n <= 0)
            return 0;

        int[] s = new int[n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    s[j] = 1;
                else
                    s[j] = s[j - 1] + s[j];
            }

        int[][] status = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    status[i][j] = 1;
                else {
                    status[i][j] = status[i - 1][j] + status[i][j - 1];
                }
            }
        }
        return status[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
    }

}
