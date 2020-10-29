package com.my4tb.algorithm.stockPrb;

/**
 * 卖股票最佳时机IV：含有手续费
 * leetcode：714
 */
public class Stock_VI {

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        Stock_VI stock_vi = new Stock_VI();
        System.out.println(stock_vi.maxProfit(prices, 2));
    }

    public int maxProfit(int[] prices, int fee) {
        int p0 = 0, p1 = Integer.MIN_VALUE, temp;
        for (int price : prices) {
            temp = p0;
            p0 = Math.max(p0, p1 + price);
            p1 = Math.max(p1, temp - price - fee);
        }
        return p0;
    }

}
