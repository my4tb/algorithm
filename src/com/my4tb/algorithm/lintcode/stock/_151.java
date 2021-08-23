package com.my4tb.algorithm.lintcode.stock;

public class _151 {

    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public static int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length <= 1)
            return 0;
        // 0 -> n 天，0、1、2次交易，持有或不持有股票
        // 把买入算作一次交易
        int[][][] f = new int[prices.length + 1][3][2];
        for (int i = 0; i <= prices.length; i++) { // days
            for (int j = 0; j <= 2; j++) { // deals
                if (i == 0 || j == 0) {
                    // day 0、0 times deal 不可能持有股票，极小值表示
                    f[i][j][1] = Integer.MIN_VALUE;
                } else {
                    f[i][j][0] = Math.max(f[i - 1][j][0], f[i - 1][j][1] + prices[i - 1]);
                    f[i][j][1] = Math.max(f[i - 1][j][1], f[i - 1][j - 1][0] - prices[i - 1]);
                }
            }
        }
        /*
            为什么第二个纬度直接取2次交易的不持有股票的值？
            1. 不持有股票，因为持有股票说明仅消费，未卖出，利润一定低于不持有
            2. 直接取2次交易的值，因为理想状况下，每一次交易都能够赚钱，所以要尽可能使交易次数最大
            即使给定prices数组中的价格不能满足这种理想状况，也能够保底，及利润为0
         */
        return f[prices.length][2][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{4, 4, 6, 1, 1, 4, 2, 5}));
    }

}
