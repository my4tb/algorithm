package com.my4tb.algorithm.leetcode;

import java.util.Arrays;

public class _338 {

    /**
     * 0          0
     * 1          1
     * 2         10
     * 3         11
     * 4        100
     * 5        101
     * 6        110
     * 7        111
     *
     * 避免重复计算
     */
    private static int[] countBits(int n) {
        if (n == 0)
            return new int[]{0};
        if (n == 1)
            return new int[]{0, 1};
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i >> 1];
            if ((i & 1) == 1)
                f[i] += 1;
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(7)));
    }

}
