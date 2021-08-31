package com.my4tb.algorithm.lintcode;

public class _513 {

    /**
     * last step, 设最优策略中最后一个完全平方数 j^2
     * sub prb, 最优策略中 n - j^2 也一定被划分成最少的完全平方数
     * state transition equation, f[i] means the min num of i can be consisted by square number
     *  f[i] = min{1 <= j^2 <= i | f[i - j^2] + 1}
     * init, f[1] = 1
     *
     * 利用 dp 方式，大数求解空间占用较高，可以根据 四平方和定理 求解
     */
    private static int numSquares(int n) {
        // write your code here
        if (n <= 0)
            return 0;
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            int temp;
            f[i] = i;
            for (int j = 1; (temp = j * j) <= i; j++)
                f[i] = Math.min(f[i], f[i - temp] + 1);
        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(1000000000));
        System.out.println(numSquares(100000000));
    }

}
