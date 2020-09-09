package com.my4tb.algorithm.backpack;

import java.util.Scanner;

/**
 * 完全背包问题，给定若干物品对应的重量和价值，以及一个背包能承重的上限，求最大价值，每个物品选取次数没有上限
 */
public class AbsoluteBackpack {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int V = scan.nextInt(); // 总体积
        int[] vs = new int[N]; // 单个体积
        int[] ws = new int[N]; // 单个价值
        for (int i = 0; i < N; i++) {
            vs[i] = scan.nextInt();
            ws[i] = scan.nextInt();
        }
        AbsoluteBackpack absoluteBackpack = new AbsoluteBackpack();
        System.out.println(absoluteBackpack.maxVal(vs, ws, V));
//        int[][] dp = new int[N + 1][V + 1];
//        for (int i = 1; i <= N; i++)
//            for (int j = 1; j <= V; j++)
//                for (int k = 0; k * vs[i - 1] <= j; k++)
//                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * vs[i - 1]] + k * ws[i - 1]);
//
//        System.out.println(dp[N][V]);
    }

    public int maxValue(int[] weights, int[] values, int capacity) {
        int[][] dp = new int[weights.length + 1][capacity + 1];
        for (int i = 1; i <= weights.length; i++)
            for (int j = 1; j <= capacity; j++)
                for (int k = 0; k * weights[i - 1] <= j; k++)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * weights[i - 1]] + k * values[i - 1]);

        return dp[weights.length][capacity];
    }

    public int maxVal(int[] weights, int[] values, int capacity) {
        int[] f = new int[capacity + 1];
        for (int i = 1; i <= weights.length; i++)
            for (int j = weights[i - 1]; j <= capacity; j++)
                f[j] = Math.max(f[j], f[j - weights[i - 1]] + values[i - 1]);
        return f[capacity];
    }

}
