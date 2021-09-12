package com.my4tb.algorithm.lintcode;

public class _125 {

    /**
     * 背包问题小结：背包容量为m，状态保存方面，需要将容量状态包含进来
     * 如f[i][j]表示前i个物品，最大容量为m时的状态
     * <p>
     * 对于本题，状态即为最大价值
     */
    private static int backPackII(int m, int[] A, int[] V) {
        // write your code here
        if (m == 0)
            return 0;

        int[][] f = new int[A.length + 1][m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= A[i - 1])
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - A[i - 1]] + V[i - 1]);
            }
        }

        return f[A.length][m];
    }

    private static int backPackIIOptimized(int m, int[] A, int[] V) {
        if (m == 0)
            return 0;
        int[] f = new int[m + 1];
        for (int i = 1; i <= A.length; i++)
            for (int j = m; j >= 0; j--)
                if (j >= A[i - 1])
                    f[j] = Math.max(f[j], f[j - A[i - 1]] + V[i - 1]);
        return f[m];
    }

    public static void main(String[] args) {
        System.out.println(backPackII(10, new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}));
        System.out.println(backPackII(10, new int[]{2, 3, 8}, new int[]{2, 5, 8}));
        System.out.println("-------------");
        System.out.println(backPackIIOptimized(10, new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}));
        System.out.println(backPackIIOptimized(10, new int[]{2, 3, 8}, new int[]{2, 5, 8}));
    }

}
