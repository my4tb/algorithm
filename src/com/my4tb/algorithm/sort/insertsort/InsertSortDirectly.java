package com.my4tb.algorithm.sort.insertsort;

import java.util.Arrays;

/**
 * 给定数组A[1, n]，假设A[1, i]已经有序，而A[i + 1, n]无序，
 * 当前待排序元素为curr = A[i + 1]，我们可以将curr依次与A[1, i]
 * 区间内的元素比较，为curr找到合适位置，并插入到该位置。
 *
 * 平均时间复杂度：O(n^2)
 * 最好时间复杂度：数组初始有序，O(n)
 * 最差时间复杂度：数组初始倒序，O(n^2)
 *
 * 稳定
 */
public class InsertSortDirectly {

    public static void main(String[] args) {
        int[] arrs = {3, 1, 5, 7, 2, 1, 2, 9, 6, 4};
        insertSort1(arrs);
        System.out.println(Arrays.toString(arrs));
    }

    private static void insertSort1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int target = nums[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (nums[j] <= target)
                    break;
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = target;
        }
    }

    private static void insertSort(int[] arrs) {
        for (int i = 1; i < arrs.length; i++) {
            int curr = arrs[i];
            int idx = i - 1;
            while (idx >= 0) {
                if (arrs[idx] > curr)
                    arrs[idx + 1] = arrs[idx--];
                else
                    break;
            }
            arrs[idx + 1] = curr;
        }
    }

}
