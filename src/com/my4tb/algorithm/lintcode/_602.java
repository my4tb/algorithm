package com.my4tb.algorithm.lintcode;

import java.util.Arrays;

public class _602 {

    /**
     * 思路类似最长子序列，但是需要先对二维数组排序
     */
    private static int maxEnvelopes(int[][] envelopes) {
        // write your code here
        if (envelopes == null || envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        int[] f = new int[envelopes.length];
        f[0] = 1;
        int max = 1;
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            if (f[i] == 0)
                f[i] = 1;
            max = Math.max(max, f[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        maxEnvelopes(new int[][]{{3, 2}, {2, 2}, {1, 2}, {1, 3}});
        System.out.println(maxEnvelopes(new int[][]{
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3},
        }));
        System.out.println(maxEnvelopes(new int[][]{
                {4, 5},
                {4, 6},
                {6, 7},
                {2, 3},
                {1, 1}
        }));
    }

}
