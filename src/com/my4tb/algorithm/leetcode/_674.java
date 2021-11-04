package com.my4tb.algorithm.leetcode;

public class _674 {

    /**
     * f[i] 以下标i元素为最后一个元素的最长连续序列长度
     */
    private static int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int[] f = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                f[0] = 1;
                max = 1;
            } else {
                if (nums[i] > nums[i - 1])
                    f[i] = f[i - 1] + 1;
                else
                    f[i] = 1;
                max = Math.max(max, f[i]);
            }
        }
        return max;
    }

    private static int findLengthOfLCISOptimized(int[] nums) {
        int max = 0;
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                max = 1;
                pre = nums[i];
                nums[i] = 1;
            } else {
                if (nums[i] > pre) {
                    pre = nums[i];
                    nums[i] = nums[i - 1] + 1;
                } else {
                    pre = nums[i];
                    nums[i] = 1;
                }
                max = Math.max(max, nums[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLengthOfLCISOptimized(new int[]{1, 3, 5, 4, 7}));
        System.out.println(findLengthOfLCISOptimized(new int[]{2, 2, 2, 2}));
    }

}
