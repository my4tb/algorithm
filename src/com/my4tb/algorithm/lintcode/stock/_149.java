package com.my4tb.algorithm.lintcode.stock;

public class _149 {

    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public static int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length <= 1)
            return 0;
        int min = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min)
                profit = Math.max(profit, prices[i] - min);
            else if (prices[i] < min)
                min = prices[i];
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{5, 4, 3, 2, 1}));
    }

}
