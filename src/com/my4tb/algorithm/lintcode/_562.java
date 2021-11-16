package com.my4tb.algorithm.lintcode;

import java.util.Arrays;

/**
 * 相似题目，lintcode 564 组合总合IV
 *
 * 首先区分组合和排列<p>
 *  1. 组合，无顺序<p>
 *  2. 排列，有顺序<p>
 *
 * 依据题目，知道本题是求达到目标target，元素的组合数，也就是说元素相同、顺序不同时，不能算作不同情况
 *
 * 为了达到去重复效果，需要外层循环遍历元素，内层循环遍历背包容量
 *
 * 以下为例，nums = {1, 5}：
 * 采取外层遍历元素策略时，先将元素1加入计算，然后元素5加入计算
 * 也就是说只会出现1、5的情况，不会出现5、1的情况
 *
 * 最后，如果是排列，也就是强调顺序，那么内层遍历元素策略时，同一个target值，1、5和5、1的顺序都会纳入计算
 */
public class _562 {

    private static int backPackIV(int[] nums, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;

        for (int num : nums) {
            for (int j = num; j <= target; j++)
                f[j] += f[j - num];
            System.out.println(Arrays.toString(f));
        }

        return f[target];
    }

    public static void main(String[] args) {
        System.out.println(backPackIV(new int[]{2, 3, 6, 7}, 7));
    }

}
