package com.my4tb.algorithm.leetcode;

public class _121 {

    private static int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int profit = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min)
                profit = Math.max(profit, prices[i] - min);
            else
                min = prices[i];
        }

        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

}
