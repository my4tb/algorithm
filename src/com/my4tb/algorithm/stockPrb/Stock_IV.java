package com.my4tb.algorithm.stockPrb;

/**
 * 卖股票最佳时机IV：最多可以完成k笔交易
 * leetcode：188
 */
public class Stock_IV {

    public static void main(String[] args) {
        Stock_IV stock_iv = new Stock_IV();
        int[] prices = {3,2,6,5,0,3};
        System.out.println(stock_iv.maxProfit(2, prices));
    }

    public int maxProfit(int k, int[] prices) {
        /*
            判断交易次数k与总天数的关系，如果k值大于价格总天数的一半，
            这个问题就转换为“无限交易次数股票问题”，否则此问题就和“最
            多交易两次股票问题”一样。
         */
        if (k >= (prices.length >> 1))
            return maxProfitInfinitely(prices);
        else
            return maxProfitK(prices, k);
    }

    public int maxProfitK(int[] prices, int k) {
        int[][][] profits = new int[prices.length + 1][k + 1][2];
        for (int i = 0; i <= prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                if (i == 0 || j == 0)
                    profits[i][j][1] = Integer.MIN_VALUE;
                else {
                    profits[i][j][0] = Math.max(profits[i - 1][j][0], profits[i - 1][j][1] + prices[i - 1]);
                    profits[i][j][1] = Math.max(profits[i - 1][j][1], profits[i - 1][j - 1][0] - prices[i - 1]);
                }
            }
        }
        return profits[prices.length][k][0];
    }

    public int maxProfitInfinitely(int[] prices) {
        int p0 = 0, p1 = Integer.MIN_VALUE, temp;
        for (int price : prices) {
            temp = p0;
            p0 = Math.max(p0, p1 + price);
            p1 = Math.max(p1, temp - price);
        }
        return p0;
    }

}












