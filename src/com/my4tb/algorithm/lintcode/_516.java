package com.my4tb.algorithm.lintcode;

import java.util.Arrays;

public class _516 {

    private static int minCostII(int[][] costs) {
        // write your code here
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int m = costs.length, n = costs[0].length;
        int[][] f = new int[m][n];
        f[0] = Arrays.copyOf(costs[0], n);
//        System.out.println(Arrays.toString(f[0]));
        for (int i = 1; i < m; i++) {
            int mi = findMinIdx(f[i - 1]);
            int smi = findSecondMinIdx(f[i - 1], mi);
            int miv = f[i - 1][mi];
            int smiv = f[i - 1][smi];
            for (int j = 0; j < n; j++) {
                if (j == mi)
                    f[i][j] = smiv + costs[i][j];
                else
                    f[i][j] = miv + costs[i][j];
            }
//            System.out.println(Arrays.toString(f[i]));
        }

        int rst = Integer.MAX_VALUE;
        for (int r : f[m - 1])
            if (r < rst)
                rst = r;
        return rst;
    }

    private static int findMinIdx(int[] nums) {
        int min = nums[0];
        int minIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

    private static int findSecondMinIdx(int[] nums, int minIdx) {
        int secondMin = Integer.MAX_VALUE;
        int secondMinIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i == minIdx)
                continue;
            if (nums[i] < secondMin) {
                secondMinIdx = i;
                secondMin = nums[i];
            }
        }
        return secondMinIdx;
    }

    public static void main(String[] args) {
        int[][] costs = new int[][]{
                {3, 5, 3},
                {6, 17, 6},
                {7, 13, 18},
                {9, 10, 18},
        };
        System.out.println(minCostII(costs));
    }

}
