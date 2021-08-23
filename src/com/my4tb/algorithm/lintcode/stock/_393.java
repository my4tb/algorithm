package com.my4tb.algorithm.lintcode.stock;

public class _393 {

    /**
     * @param k:      An integer
     * @param prices: An integer array
     * @return: Maximum profit
     */
    public static int maxProfit(int k, int[] prices) {
        // write your code here
        if (prices == null || prices.length <= 1)
            return 0;
        if (k >= prices.length / 2 + 1) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++)
                if (prices[i] > prices[i - 1])
                    profit += prices[i] - prices[i - 1];
            return profit;
        }
        int[][][] f = new int[prices.length + 1][k + 1][2];
        for (int i = 0; i <= prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                if (i == 0 || j == 0)
                    f[i][j][1] = Integer.MIN_VALUE;
                else {
                    f[i][j][0] = Math.max(f[i - 1][j][0], f[i - 1][j][1] + prices[i - 1]);
                    f[i][j][1] = Math.max(f[i - 1][j][1], f[i - 1][j - 1][0] - prices[i - 1]);
                }
            }
        }
        return f[prices.length][k][0];
    }

    // 从原始到这里的优化，只考虑降维，不考虑实际意义
    public static int maxProfitI(int k, int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        if (k >= prices.length / 2 + 1) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++)
                if (prices[i] > prices[i - 1])
                    profit += prices[i] - prices[i - 1];
            return profit;
        }
        int[][] f = new int[k + 1][2];
        for (int i = 0; i <= prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                if (i == 0 || j == 0)
                    f[j][1] = Integer.MIN_VALUE;
                else {
                    f[j][0] = Math.max(f[j][0], f[j][1] + prices[i - 1]);
                    f[j][1] = Math.max(f[j][1], f[j - 1][0] - prices[i - 1]);
                }
            }
        }
        return f[k][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfitI(2, new int[]{4, 4, 6, 1, 1, 4, 2, 5}));
        System.out.println(maxProfit(1, new int[]{3, 2, 1}));
    }

}
