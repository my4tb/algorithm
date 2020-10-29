package com.my4tb.algorithm.stockPrb;

/**
 * 卖股票最佳时机III：最多可以完成两笔交易
 * leetcode 123
 */
public class Stock_III {

    public static void main(String[] args) {
        Stock_III stock_iii = new Stock_III();
//        int[] prices = {3,3,5,0,0,3,1,4};
        int[] prices = {3,2,6,5,0,3};
        System.out.println(stock_iii.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int[][][] profits = new int[prices.length + 1][3][2];
        for (int i = 0; i <= prices.length; i++) {
            for (int j = 0; j <= 2; j++) {
                if (i == 0 || j == 0)
                    profits[i][j][1] = Integer.MIN_VALUE;
                else {
                    profits[i][j][0] = Math.max(profits[i - 1][j][0], profits[i - 1][j][1] + prices[i - 1]);
                    profits[i][j][1] = Math.max(profits[i - 1][j][1], profits[i - 1][j - 1][0] - prices[i - 1]);
                }
            }
        }
        return profits[prices.length][2][0];
    }

}
