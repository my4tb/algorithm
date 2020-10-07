package com.my4tb.algorithm.sort.insertsort;

import java.util.Arrays;

/**
 * 选取步长，先排序大分组，使得数组整体有序，然后逐渐缩小步长。
 *
 * 一方面，按步长分组，每组是一个小规模问题，能够提高插入排序效率。
 * 另一方面，每一次按步长的排序，都会使得整体问题更加有序，从而也提升了插入排序的效率。
 *
 * 时间复杂度：该复杂度与增量即gap相关
 *
 * 稳定性：以小样本插入排序时，存在破坏稳定性的可能。
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arrs = {3, 1, 5, 7, 2, 1, 2, 9, 6, 4};
        shellSort1(arrs);
        System.out.println(Arrays.toString(arrs));
    }

    private static void shellSort1(int[] nums) {
        for (int gap = nums.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < nums.length; i++) {
                int curr = nums[i];
                int idx = i - gap;
                while (idx >= 0) {
                    if (nums[idx] <= curr)
                        break;
                    nums[idx + gap] = nums[idx];
                    idx -= gap;
                }
                nums[idx + gap] = curr;
            }
        }
    }

    private static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int curr = arr[i];
                int idx = i - gap;
                while (idx >= 0) {
                    if (arr[idx] > curr) {
                        arr[idx + gap] = arr[idx];
                        idx -= gap;
                    }
                    else
                        break;
                }
                arr[idx + gap] = curr;
            }
            System.out.println(Arrays.toString(arr));
        }
    }

}
