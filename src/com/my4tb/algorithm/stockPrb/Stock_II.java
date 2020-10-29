package com.my4tb.algorithm.stockPrb;

/**
 * 买卖股票最佳时机II：尽可能多的完成交易
 * leetcode 122
 */
public class Stock_II {

    public static void main(String[] args) {
        Stock_II stock_ii = new Stock_II();
        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(stock_ii.maxProfit(prices));
        System.out.println(stock_ii.maxProfit1(prices));
    }

    public int maxProfit(int[] prices) {
        /*
            没有交易次数限制，相比于leetcode 121，这里不需要第二个维度。
         */
        int[][] profits = new int[prices.length + 1][2];
        profits[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            profits[i][0] = Math.max(profits[i - 1][0], profits[i - 1][1] + prices[i - 1]);
            profits[i][1] = Math.max(profits[i - 1][1], profits[i - 1][0] - prices[i - 1]);
        }
        return profits[prices.length][0];
    }

    public int maxProfit1(int[] prices) {
        int p0 = 0, p1 = Integer.MIN_VALUE, temp;
        for (int price : prices) {
            temp = p0;
            p0 = Math.max(p0, p1 + price);
            p1 = Math.max(p1, temp - price);
        }
        return p0;
    }

}
