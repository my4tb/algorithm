package com.my4tb.algorithm.leetcode;

public class _213 {

    /**
     * 区间问题，首位相连，不能同时取
     * max(nums[0, len-2], nums[1, len-1])
     */
    private static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int _1 = maxPFromInterval(0, nums.length - 2, nums);
        int _2 = maxPFromInterval(1, nums.length - 1, nums);
        return Math.max(_1, _2);
    }

    private static int maxPFromInterval(int l, int r, int[] nums) {
        if (l == r)
            return nums[l];
        else if (r - l == 1)
            return Math.max(nums[r], nums[l]);
        else {
            int preP = 0;
            int p = nums[l];
            int curr;
            for (int i = l + 1; i <= r; i++) {
                curr = Math.max(nums[i] + preP, p);
                preP = p;
                p = curr;
            }
            return p;
        }
    }

    public static void main(String[] args) {
        System.out.println(maxPFromInterval(0, 4, new int[]{2, 7, 9, 3, 1}));
        System.out.println(maxPFromInterval(0, 2, new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 3, 2}));
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{0, 1}));
    }

}
