package com.my4tb.algorithm.leetcode;

public class _300 {

    /**
     * f[i] 以i为下标的元素为结尾的最长子序列
     */
    private static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length;
        int[] f = new int[len];
        f[0] = 1;

        int rst = 1;

        for (int i = 1; i < len; i++) {
            int curr = nums[i];
            int max = 0;
            for (int j = 0; j < i; j++)
                if (nums[j] < curr)
                    max = Math.max(max, f[j]);
            f[i] = max + 1;
            rst = Math.max(rst, f[i]);
        }

        return rst;
    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }

}
