package com.my4tb.algorithm.zuo;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序平均时间复杂度为O(nlogn)，但是如果数组大致有序或者已经有序，时间复杂度会退化为O(n^2)
 * 因此引入随机快排，也就是说不使用区间内的最后一个元素，而是随机选取一个区间内的元素。
 * 随机快排的空间复杂度为O(logn)
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] nums = new int[] {5, 2, 1, 6, 6, 7, 2, 1};
        quickSort(0, nums.length - 1, nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int l, int r, int[] nums) {
        if (l < r) {
            swap(new Random().nextInt(r) % (r - l + 1) + l, r, nums); // 随机快排
            int[] p = partition(l, r, nums);
            quickSort(l, p[0] - 1, nums);
            quickSort(p[1] + 1, r, nums);
        }
    }

    /**
     * 排序[l, r]区间元素，一个partition的过程的时间复杂度为O(n)，空间复杂度为O(1)
     * @param l 左端点下标
     * @param r 右端点下标
     * @param nums 排序数组
     * @return 与枢轴值相等的元素下标区间
     */
    private static int[] partition(int l, int r, int[] nums) {
        int less = l - 1, more = r, idx = l, target = nums[r];
        while (idx < more) {
            if (nums[idx] == target)
                idx++;
            else if (nums[idx] < target)
                swap(idx++, ++less, nums);
            else
                swap(idx, --more, nums);
        }
        /*
            最后一个元素作为枢轴值，与target相等，最后要移动到中间
         */
        swap(more, r, nums);
        return new int[] {less + 1, more};
    }

    private static void swap(int i, int j, int[] nums) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

}
