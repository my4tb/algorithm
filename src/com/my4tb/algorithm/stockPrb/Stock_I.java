package com.my4tb.algorithm.stockPrb;

/**
 * 买卖股票最佳时机I：最多只能完成一笔交易
 * leetcode 121
 */
public class Stock_I {

    public static void main(String[] args) {
        Stock_I stock_i = new Stock_I();
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {7,6,4,3,1};
        System.out.println(stock_i.maxProfit(prices));
        System.out.println(stock_i.maxProfit1(prices));
    }

    /**
     * 用三个维度的数组表示利润是最朴素的方式，根据这种思想，可以进行一定的简化。
     */
    public int maxProfit(int[] prices) {
        /*
            profits[i][j][k]表示第i天进行第j笔交易后持有或不持有股票的利润，
            从第0天开始，因为最多完成1笔交易，因此第二个维度长度为2，即最多完
            成0或1笔交易，第三个维度长度为2，0表示不持有股票，1表示持有股票。
         */
        int[][][] profits = new int[prices.length + 1][2][2];
        for (int i = 0; i <= prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (i == 0 || j == 0) {
                    /*
                        第0天或最多只进行0笔交易时，是不可能持有股票的。
                        不可能发生的利润用Integer.MIN_VALUE表示，否则为0。
                     */
                    profits[i][j][1] = Integer.MIN_VALUE;
                }
                else {
                    profits[i][j][0] = Math.max(profits[i - 1][j][0], profits[i - 1][j][1] + prices[i - 1]);
//                    profits[i][j][1] = Math.max(profits[i - 1][j][1], profits[i - 1][j - 1][0] - prices[i - 1]);
                    /*
                        因为最多只进行一次交易，因此在这次交易发生前，利润一定是0，只需要在prices[i - 1]加上一个负号即可。
                        如果可以进行多次交易，那么这里不能直接加负号，必须写成最原始形式。
                     */
                    profits[i][j][1] = Math.max(profits[i - 1][j][1], -prices[i - 1]);
                }
            }
        }
        /*
            返回值，表示最后一天的股价，最多完成1笔交易，不持有股票的最大利润。
            最后一天不持有股票的利润一定是大于持有股票的利润的。
         */
        return profits[prices.length][1][0];
    }

    public int maxProfit1(int[] prices) {
        int p0 = 0, p1 = Integer.MIN_VALUE;
        for (int price : prices) {
            p0 = Math.max(p0, p1 + price);
            p1 = Math.max(p1, -price);
        }
        return p0;
    }

}
