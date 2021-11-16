package com.my4tb.algorithm.lintcode;

public class _562 {

    private static int backPackIV(int[] nums, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;

        /*
            外层循环必须遍历nums
         */
        for (int num : nums)
            for (int j = num; j <= target; j++)
                f[j] += f[j - num];
        return f[target];
    }

    public static void main(String[] args) {
        System.out.println(backPackIV(new int[]{2, 3, 6, 7}, 7));
    }

}
