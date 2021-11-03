package com.my4tb.algorithm.leetcode;

public class _123 {

    /**
     * f[i][j][2] 前i天最多j次交易是否持有的最大利润
     * 买入算作一次交易
     */
    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int len = prices.length;
        int[][][] f = new int[len + 1][3][2];

        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= 2; j++) {
                if (i == 0 || j == 0)
                    f[i][j][1] = Integer.MIN_VALUE;
                else {
                    f[i][j][0] = Math.max(f[i - 1][j][1] + prices[i - 1], f[i - 1][j][0]);
                    f[i][j][1] = Math.max(f[i - 1][j - 1][0] - prices[i - 1], f[i - 1][j][1]);
                }
            }
        }

        return f[len][2][0];
    }

    private static int maxProfitOptimized(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int[][] f = new int[3][2];

        for (int i = 0; i <= prices.length; i++)
            for (int j = 0; j <= 2; j++)
                if (i == 0 || j == 0)
                    f[j][1] = Integer.MIN_VALUE;
                else {
                    f[j][0] = Math.max(f[j][1] + prices[i - 1], f[j][0]);
                    f[j][1] = Math.max(f[j - 1][0] - prices[i - 1], f[j][1]);
                }

        return f[2][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(maxProfitOptimized(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(maxProfit(new int[]{1, 0}));
        System.out.println(maxProfitOptimized(new int[]{1, 0}));
    }

}
