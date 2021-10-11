package com.my4tb.algorithm.lintcode;

public class _89 {

    private static int kSum(int[] nums, int k, int target) {
        // write your code here
        int len = nums.length;
        int[][][] f = new int[len + 1][k + 1][target + 1]; // f[i][j][t]表示从前i个数中选j个组成t的方案数
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= k && j <= i; j++) {
                for (int t = 0; t <= target; t++) {
                    if (i == 0) {
                        if (j == 0 && t == 0) // 选0个数组成0的方案数为1
                            f[i][j][t] = 1;
                    } else {
                        f[i][j][t] = f[i - 1][j][t];
                        if (j != 0 && t >= nums[i - 1])
                            f[i][j][t] += f[i - 1][j - 1][t - nums[i - 1]];
                    }
                }
            }
        }
        return f[len][k][target];
    }

    private static int kSumOptimized(int[] nums, int k, int target) {
        int len = nums.length;
        int[][][] f = new int[2][k + 1][target + 1];
        int rn = 0;
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= k && j <= i; j++) {
                for (int t = 0; t <= target; t++) {
                    if (i == 0) {
                        if (j == 0 && t == 0) {
                            f[rn][j][t] = 1;
                        }
                    } else {
                        f[rn][j][t] = f[1 - rn][j][t];
                        if (j != 0 && t >= nums[i - 1])
                            f[rn][j][t] += f[1 - rn][j - 1][t - nums[i - 1]];
                    }
                }
            }
            rn = 1 - rn;
        }
        return f[1 - rn][k][target];
    }

    public static void main(String[] args) {
        System.out.println(kSum(new int[]{1, 2, 3, 4}, 2, 5));
        System.out.println(kSum(new int[]{1, 2, 3, 4, 5}, 3, 6));
        System.out.println(kSumOptimized(new int[]{1, 2, 3, 4}, 2, 5));
        System.out.println(kSumOptimized(new int[]{1, 2, 3, 4, 5}, 3, 6));
    }

}
