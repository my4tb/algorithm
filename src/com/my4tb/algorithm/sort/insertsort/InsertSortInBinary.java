package com.my4tb.algorithm.sort.insertsort;

import java.util.Arrays;

/**
 * 先利用二分查找算法找到待插入元素位置，然后统一向后移动。
 * 这种方式减少了元素的比较次数，比较的时间复杂度为O(nlogn)。
 * 但是移动元素的时间复杂度没有变化，仍以来于元素排列的初始状态。
 *
 * 时间复杂度：O(n^2)
 */
public class InsertSortInBinary {

    public static void main(String[] args) {
        int[] arrs = {3, 1, 5, 7, 2, 1, 2, 9, 6, 4};
        insertSort1(arrs);
        System.out.println(Arrays.toString(arrs));
    }

    private static void insertSort1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int position = findInsertPosition1(nums, 0, i);
            if (i - position >= 0)
                System.arraycopy(nums, position, nums, position + 1, i - position);
            nums[position] = curr;
        }
    }

    // 找到第一个大于target的position
    private static int findInsertPosition1(int[] arr, int l, int r) {
        int target = arr[r];
        int mid;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (arr[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    private static void insertSort(int[] arrs) {
        for (int i = 1; i < arrs.length; i++) {
            int curr = arrs[i];
            int position = findInsertPosition(arrs, curr, 0, i - 1);
            if (i - position >= 0)
                System.arraycopy(arrs, position, arrs, position + 1, i - position);
            arrs[position] = curr;
        }
    }

    private static int findInsertPosition(int[] arr, int target, int l, int r) {
        int mid;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (arr[mid] <= target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }

}
