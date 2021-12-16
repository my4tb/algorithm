package com.my4tb.algorithm.leetcode;

import java.util.Arrays;

public class _1646 {

    private static int getMaximumGenerated(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        int end = (n - 1) / 2;
        for (int i = 1; i <= end; i++) {
            f[2 * i] = f[i];
            if (2 * i + 1 <= n) {
                f[2 * i + 1] = f[i] + f[i + 1];
            }

        }
        int rst = 1;
        for (int i = 2; i <= n; i++)
            if (f[i] > rst)
                rst = f[i];

        System.out.println(Arrays.toString(f));

        return rst;
    }

    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(7));
    }

}
