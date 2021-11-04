package com.my4tb.algorithm.leetcode;

public class _198 {

    /**
     * 最优解，偷过的最后一间房间
     * f[i] 表示前i间房子获取最大金额
     */
    private static int rob(int[] nums) {
        int len = nums.length;
        int[] f = new int[len + 1];
        f[0] = 0;
        for (int i = 1; i <= len; i++) {
            if (i == 1)
                f[i] = nums[i - 1];
            else
                f[i] = Math.max(nums[i - 1] + f[i - 2], f[i - 1]);
        }

        return f[len];
    }

    private static int robOptimized(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return nums[0];
        int preP = 0;
        int p = nums[0];
        int curr;
        for (int i = 2; i <= len; i++) {
            curr = Math.max(preP + nums[i - 1], p);
            preP = p;
            p = curr;
        }
        return p;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(robOptimized(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(robOptimized(new int[]{2, 7, 9, 3, 1}));
    }

}
