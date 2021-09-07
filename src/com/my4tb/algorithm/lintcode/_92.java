package com.my4tb.algorithm.lintcode;

public class _92 {

    /**
     * 最优策略中，假设第i件物品重量为t，前i件物品能够拼出了总重量m，
     * 那么有两种可能性：
     * 1. 前i-1件物品已经拼出了总重量m，不需要第i件物品
     * 2. 前i-1件物品已经拼出了总重量m-t，加上第i件物品恰好拼出总重量m
     * 设f[i][j]表示前i件物品能否拼出总重量j即可
     *
     *****************************************************
     *
     * 小结：要求不超出target的最大值时，记录前i个物品能拼出哪些重量
     */
    private static int backPack(int m, int[] A) {
        // write your code here
        if (m == 0 || A == null || A.length == 0)
            return 0;
        boolean[][] f = new boolean[A.length + 1][m + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0)
                    f[i][j] = true;
                else if (i == 0)
                    f[i][j] = false;
                else {
                    // 不取当前物品和取当前物品
                    f[i][j] = f[i - 1][j];
                    if (j >= A[i - 1])
                        f[i][j] = f[i][j] || f[i - 1][j - A[i - 1]];
                }
            }
        }
        for (int i = m; i >= 0; i--)
            if (f[A.length][i])
                return i;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(backPack(10, new int[]{3, 4, 8, 5}));
        System.out.println(backPack(12, new int[]{2, 3, 5, 7}));
    }

}
