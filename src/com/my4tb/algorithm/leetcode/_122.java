package com.my4tb.algorithm.leetcode;

public class _122 {

    private static int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int profit = 0;

        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];

        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

}
