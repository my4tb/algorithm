package com.my4tb.algorithm.lintcode;

public class _515 {

    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public static int minCost(int[][] costs) {
        // write your code here
        int m, n;
        if (costs == null || (m = costs.length) == 0 || (n = costs[0].length) == 0)
            return 0;
        int[][] f = new int[m][n];
        System.arraycopy(costs[0], 0, f[0], 0, n);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = -1;
                for (int c = 0; c < n; c++) {
                    if (c == j)
                        continue;
                    if (min == -1)
                        min = f[i - 1][c];
                    else
                        min = Math.min(min, f[i - 1][c]);
                }
                f[i][j] = min + costs[i][j];
            }
        }
        return Math.min(f[m - 1][0], Math.min(f[m - 1][1], f[m - 1][2]));
    }

    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{
                {1, 2, 3},
                {1, 4, 6},
        }));
    }

}
