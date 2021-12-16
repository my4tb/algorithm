package com.my4tb.algorithm.leetcode;

import java.util.*;

public class _LCP07 {

    private static int numWays(int n, int[][] relation, int k) {
        // 最优策略下，第k轮由t号玩家传递给n-1号玩家
        // 要去找第k-1轮由哪位玩家传递给t号玩家
        // f[i][j]表示第i轮游戏传递给j号玩家的方案数
        Map<Integer, Set<Integer>> state = new HashMap<>();
        for (int[] r : relation) {
            int from = r[0];
            int to = r[1];
            state.computeIfAbsent(to, f -> new HashSet<>()).add(from);
        }

        int[][] f = new int[k + 1][n];
        f[0][0] = 1; // 第0轮游戏（未开始）信息在0号小朋友，即1种方式
        System.out.println(Arrays.toString(f[0]));
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (state.get(j) != null) {
                    for (Integer fm : state.get(j)) {
                        f[i][j] += f[i - 1][fm];
                    }
                }
            }
            System.out.println(Arrays.toString(f[i]));
        }

        return f[k][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(numWays(3, new int[][]{
                {0, 2},
                {2, 1}
        }, 2));
    }

}
