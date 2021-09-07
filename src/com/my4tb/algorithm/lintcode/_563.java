package com.my4tb.algorithm.lintcode;

import java.util.Arrays;

public class _563 {

    /**
     * 与_92不同在于，本题需要记录方案数
     */
    private static int backPackV(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0 || target == 0)
            return 0;
        int n = nums.length;
        int[][] f = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j == 0)
                    f[i][j] = 1;
                else if (i == 0)
                    f[i][j] = 0;
                else {
                    f[i][j] = f[i - 1][j];
                    if (j >= nums[i - 1])
                        f[i][j] += f[i - 1][j - nums[i - 1]];
                }
            }
        }
        return f[n][target];
    }

    private static int backPackVOptimized(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target == 0)
            return 0;
        int n = nums.length;
        int[] f = new int[target + 1];
        for (int i = 0; i <= n; i++)
            for (int j = target; j >= 0; j--)
                if (j == 0)
                    f[j] = 1;
                else if (i == 0)
                    f[j] = 0;
                else if (j >= nums[i - 1])
                        f[j] += f[j - nums[i - 1]];
        return f[target];
    }

    public static void main(String[] args) {
        System.out.println(backPackV(new int[]{1, 1, 1, 1}, 3));
        System.out.println(backPackVOptimized(new int[]{1, 1, 1, 1}, 3));
    }

}
