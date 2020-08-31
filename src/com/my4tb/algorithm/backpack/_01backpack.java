package com.my4tb.algorithm.backpack;

import java.util.Arrays;

/**
 * 01背包问题，给定若干物品对应的重量和价值，以及一个背包能承重的上限，求最大价值
 */
public class _01backpack {

    public static void main(String[] args) {
        _01backpack backpack = new _01backpack();
        System.out.println(backpack.maxValue1(new int[]{0, 2, 3, 4, 5}, new int[]{0, 1, 2, 5, 6}, 8));
    }

    // 空间优化
    public int maxValue1(int[] weights, int[] values, int capacity) {
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= weights.length; i++)
            for (int j = capacity; j >= weights[i - 1]; j--)
                dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
        return dp[capacity];
    }

    // 常规解法
    public int maxValue(int[] weights, int[] values, int capacity) {
        /*
            dp[i][j]表示在前i件物品中选出若干，放入最大承重为j的背包中，可以得到的最大价值。
         */
        int[][] dp = new int[weights.length + 1][capacity + 1];
        /*
            i=0表示前0件物品，对应价值一定为0，同理j=0表示背包最大承重为0，价值也一定为0，
            而int数组初始化为0，因此循环从i=1、j=1开始。
         */
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                /*
                    不拿第i件物品
                 */
                dp[i][j] = dp[i - 1][j];
                /*
                    如果第i件物品单件的重量已经超出了当前背包最大承重，
                    那么就不用考虑拿当前物品的情况了。
                 */
                if (j >= weights[i - 1])
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
            }
        }

        for (int[] ints : dp)
            System.out.println(Arrays.toString(ints));

        return dp[weights.length][capacity];
    }

}
