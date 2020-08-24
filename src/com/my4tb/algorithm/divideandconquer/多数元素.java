package com.my4tb.algorithm.divideandconquer;

/**
 * leetcode 169
 * 1. 区间内只有一个元素，该元素一定是所选元素
 * 2. 合并区间时，两个区间所选元素一致，合并后的区间也一定是子区间所选元素
 * 3. 合并区间时，两个区间所选元素不一致，比较二者出现次数，出现次数较多者是合并后区间所选元素
 */
public class 多数元素 {

    public static void main(String[] args) {
//        int[] nums = new int[] {3,2,3};
        int[] nums = new int[] {};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        return divide(0, nums.length - 1, nums);
    }

    private static int divide(int l, int r, int[] nums) {
        if (l == r)
            return nums[l];
        int mid = l + ((r - l) >> 1);
        int l_num = divide(l, mid, nums);
        int r_num = divide(mid + 1, r, nums);
        if (l_num == r_num)
            return l_num;
        int l_count = countNum(l, r, l_num, nums);
        int r_count = countNum(l, r, r_num, nums);
        return l_count > r_count ? l_num : r_num;
    }

    private static int countNum(int l, int r, int num, int[] nums) {
        int count = 0;
        while (l <= r) {
            if (nums[l++] == num)
                count++;
        }
        return count;
    }

}
