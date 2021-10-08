package com.my4tb.algorithm.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _91 {

    /**
     * f[i][j]表示A中前i个元素调整后的最小代价，其中第i个元素修改后的值为j
     */
    private static int MinAdjustmentCost(List<Integer> A, int target) {
        // write your code here
        int[][] f = new int[A.size() + 1][101];
        for (int i = 0; i <= A.size(); i++) {
            for (int j = 0; j <= 100; j++) {
                if (i == 0) // 前0个元素调整的最小代价为0
                    f[i][j] = 0;
                else {
                    int currCost = Math.abs(j - A.get(i - 1));
                    int min = Integer.MAX_VALUE;
                    int start = Math.max(0, j - target);
                    int end = Math.min(j + target, 100);
                    for (int t = start; t <= end; t++) {
                        min = Math.min(min, f[i - 1][t]);
                    }
                    f[i][j] = currCost + min;
                }
            }
        }

        int rst = Integer.MAX_VALUE;
        for (int num : f[A.size()])
            rst = Math.min(rst, num);

        return rst;
    }

    public static void main(String[] args) {
        System.out.println(MinAdjustmentCost(Arrays.asList(1, 4, 2, 3), 1));
        System.out.println(MinAdjustmentCost(Arrays.asList(3, 5, 4, 7), 2));
    }

}
