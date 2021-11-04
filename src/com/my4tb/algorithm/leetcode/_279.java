package com.my4tb.algorithm.leetcode;

public class _279 {

    private static int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        int[] f = new int[n + 1];
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int squire;
            for (int j = 1; (squire = j * j) <= i; j++) {
                min = Math.min(min, f[i - squire]);
                if (min == 0)
                    break;
            }
            f[i] = 1 + min;
        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }

}
