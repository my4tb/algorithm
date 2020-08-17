package com.my4tb.algorithm.zuo;

/**
 * leetcode:295
 */
public class 堆排序 {

    /**
     * 插入一个节点，时间复杂度为O(logn)，即完全二叉树的高度。
     * 对于一个长度为n的数组nums，所有元素都插入一遍，时间复杂
     * 度为O(log1 + log2 + ... + log(n - 1) + logn) = O(n)，
     * 即建立堆的过程时间复杂度为O(n)。
     */
    public void heapInsert(int idx, int[] nums) {
        while (nums[idx] > nums[(idx - 1) / 2]) {
            swap(idx, (idx - 1) / 2, nums);
            idx = (idx - 1) / 2;
        }
    }

    /**
     * 某个元素发生变化，元素下沉的过程，如果是大根堆，将变化的元素和孩子元素比较，
     * 与较大的孩子交换位置，直到变化的元素比所有孩子元素值都大。
     * @param nums
     * @param idx
     * @param heapSize
     */
    public void heapify(int[] nums, int idx, int heapSize) {
        int left = idx * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && nums[left] < nums[left + 1] ? left + 1 : left;
            largest = nums[idx] > nums[largest] ? idx : largest;
            if (largest == idx)
                break;
            swap(idx, largest, nums);
            idx = largest;
            left = idx * 2 + 1;
        }
    }

    private void swap(int i, int j, int[] nums) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

}
