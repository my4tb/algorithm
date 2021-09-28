package com.my4tb.algorithm.binarysearch;

public class _3 {

    /**
     * 找到nums中第一个大于target的元素下标
     */
    private static int _3(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] > target)
                r = mid - 1;
            else if (nums[mid] <= target)
                l = mid + 1;
        }
        return r + 1;
    }

    public static void main(String[] args) {
        System.out.println(_3(new int[]{1, 1, 3, 3, 3}, 3));
        System.out.println(_3(new int[]{1, 2, 3, 3, 3}, 0));
        System.out.println(_3(new int[]{1, 2, 3, 3, 3}, 2));
    }

}
