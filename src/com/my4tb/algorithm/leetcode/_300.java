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

    /**
     * 优化思路，让整个递增序列尽可能慢的上升
     * <p>
     * f[i] 表示长度为i的子序列的最后一个元素的最小值
     * <p>
     * nums -> {1, 4, 3, 2, 3}
     * <p>
     * f -> {1, 2, 3, 0, 0}
     */
    private static int lengthOfLISOptimized(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int tail = 0;
        for (int i = 1; i < nums.length; i++) {
            int firstBiggerIdx = findFirstBiggerIdx(0, tail, nums[i], f);
            f[firstBiggerIdx] = nums[i];
            if (firstBiggerIdx > tail)
                tail++;
        }
        return tail + 1;
    }

    private static int findFirstBiggerIdx(int l, int r, int target, int[] nums) {
        int mid;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] > target)
                r--;
            else
                l++;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLISOptimized(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(lengthOfLISOptimized(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
        System.out.println(lengthOfLISOptimized(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }

}
