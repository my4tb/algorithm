package com.my4tb.algorithm.zuo;

import java.util.Arrays;

/**
 * 给定一个数组和一个target，使小于target的数在左，等于target的数在中间，大于target的数在右
 * leetcode:75
 */
public class 荷兰国旗问题 {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 5, 7, 2, 1, 8, 8, 5};
        solution(nums, 5);
        System.out.println(Arrays.toString(nums));
    }

    public static void solution(int[] nums, int target) {
        /*
            [0, less]是所有小于target的元素
            [more, len - 1]是所有大于target的元素
            idx是遍历下标
         */
        int less = -1, more = nums.length, idx = 0;
        while (idx < more) {
            if (nums[idx] == target)
                idx++;
            else if (nums[idx] > target)
                swap(idx, --more, nums);
            else
                swap(idx++, ++less, nums);
        }
    }

    private static void swap(int i, int j, int[] nums) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

}
