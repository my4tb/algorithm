package com.my4tb.algorithm.stockPrb;

/**
 * 卖股票最佳时机IV：含有冷冻期，即卖出后的第二天不能买入股票
 * leetcode：309
 */
public class Stock_V {

    public static void main(String[] args) {
        Stock_V stock_v = new Stock_V();
        int[] prices = {1,2,3,0,2};
        System.out.println(stock_v.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int[][] profits = new int[prices.length + 1][2];
        profits[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            profits[i][0] = Math.max(profits[i - 1][0], profits[i - 1][1] + prices[i - 1]);
            profits[i][1] = Math.max(profits[i - 1][1], i == 1 ? -prices[i - 1] : profits[i - 2][0] - prices[i - 1]);
        }
        return profits[prices.length][0];
    }

}
