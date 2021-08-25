package com.my4tb.algorithm.lintcode;

public class _76 {

    /**
     * 设 f[i] 为以下标 i 为结尾的最长子序列长度，
     *  f[i] 的值为，找到 [0, i - 1] 区间内最后一个比 nums[i] 小的值，假设为下标为 j 的值，
     *  f[i] = f[j] + 1
     * 如果没有比 nums[i] 小的值，则 f[i] = 1
     * 这种时间复杂度为 O(n^2)
     */
    public static int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0)
            return 0;
        int max = 1;
        int[] f = new int[nums.length];
        f[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    f[i] = Math.max(f[j] + 1, f[i]);
                }
            }
            if (f[i] == 0)
                f[i] = 1;
            max = Math.max(max, f[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequence(new int[] {5,4,1,2,3}));
    }

}
