package com.my4tb.algorithm.binarysearch;

public class _2 {

    /**
     * 寻找在nums中第一个小于target的数的下标
     *
     * 下面实现中，找到mid后，只要比target大，都会将r变为mid-1进行收缩，
     * 所以当跳出循环时，r所只想的元素一定时比target小的（越界除外），而
     * l有可能一直都不发生变化，即初始化时指向的元素就是target，所以最后
     * 返回值为l-1
     */
    private static int _2(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] < target)
                l = mid + 1;
            else if (nums[mid] >= target)
                r = mid - 1;
        }
        return l - 1;
    }

    public static void main(String[] args) {
        System.out.println(_2(new int[]{1, 1, 3, 3, 3}, 3));
        System.out.println(_2(new int[]{1, 2, 3, 3, 3}, 0));
        System.out.println(_2(new int[]{1, 2, 3, 3, 3}, 4));
    }

}
