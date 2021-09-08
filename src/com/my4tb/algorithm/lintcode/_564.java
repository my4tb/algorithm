package com.my4tb.algorithm.lintcode;

public class _564 {

    /**
     * 元素可以无限选用，且不同顺序算做不同组合
     * 在最优策略下，最后一个元素可以是任何一个num，
     * 子问题是target - num如何组合
     */
    private static int backPackVI(int[] nums, int target) {
        // write your code here
        if (target <= 0 || nums == null || nums.length == 0)
            return 0;
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums)
                if (i >= num)
                    f[i] += f[i - num];
        }
        return f[target];
    }

    public static void main(String[] args) {
        System.out.println(backPackVI(new int[]{1,2}, 4));
    }

}
