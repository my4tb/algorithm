package com.my4tb.algorithm.binarysearch;

public class _1 {

    /**
     * 本地解法，初始化索引为l=0，r=nums.length-1，也就是数组nums的闭区间[0, nums.length-1]，
     * 每次查找都是在两个索引的闭区间搜索：[l, r]，也正是因为在闭区间内搜索，所以在跳出while循环的
     * 条件是l<=r，也就是说当l=r+1时，搜索区间为[l+1, l]时跳出while循环，显然区间[l+1, l]是不存
     * 在的，说明涵盖了区间的所有元素。
     *
     * 同样，如果初始化索引为l=0，r=nums.length，则搜索区间为开区间，最终跳出while循环的条件应该为l<r
     *
     * @param nums 自然排序数组，无重复
     * @param target 目标
     * @return 如果存在目标返回目标下标，否则返回-1
     */
    private static int _1(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                r = mid - 1;
            else if (nums[mid] < target)
                l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(_1(new int[]{1, 3, 4, 5, 6, 7, 8, 9}, 7));
        System.out.println(_1(new int[]{1, 3, 4, 5, 6, 7, 8, 9}, 2));
    }

}
