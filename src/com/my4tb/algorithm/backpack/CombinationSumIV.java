package com.my4tb.algorithm.backpack;

/**
 * leetcode 377 装入元素区分顺序，外层必须先按容量循环
 *
 * 思路可以不从背包问题出发，把dp[i]表示为和为i的组合数，根据递归树，自底向上的解法去做。
 *
 */
public class CombinationSumIV {

    public static void main(String[] args) {
        System.out.println(new CombinationSumIV().combinationSum4(new int[]{1, 2, 3}, 4));
    }

    public int combinationSum4(int[] nums, int target) {

        int[] f = new int[target + 1];
        f[0] = 1;

        for (int i = 1; i <= target; i++)
            for (int num : nums)
                if (i >= num)
                    f[i] += f[i - num];

        return f[target];

    }

}
