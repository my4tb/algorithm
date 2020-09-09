package com.my4tb.algorithm.backpack;

import java.util.Arrays;

/**
 * leetcode 416 恰好装满问题
 */
public class CanPartition {
    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        System.out.println(canPartition.canPartition(new int[]{1, 2, 3, 5, 1, 2}));
    }
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum & 1) == 1)
            return false;
        sum >>= 1;
        boolean[] f = new boolean[sum + 1];
        f[0] = true;
        for (int num : nums)
            for (int i = sum; i >= num; i--) {
                f[i] = (f[i] || f[i - num]);
                System.out.println(Arrays.toString(f));
            }
        return f[sum];
    }

}
