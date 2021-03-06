package com.my4tb.algorithm.zuo;

/**
 * leetcode:295
 *
 * 删除堆中的某个元素时，假设这个元素的下标为idx，首先将idx堆中最后一个元素swap，
 * 然后heapSize值减一，并将交换后的下标为idx的元素heapify。
 */
public class 堆排序 {

    /**
     * 插入一个节点，时间复杂度为O(logn)，即完全二叉树的高度。
     * 对于一个长度为n的数组nums，所有元素都插入一遍，时间复杂
     * 度为O(log1 + log2 + ... + log(n - 1) + logn) = O(n)，
     * 即建立堆的过程时间复杂度为O(n)。
     *
     * 完全二叉树性质：某个节点在数组中的下标为idx，那么其父节点在数组中的下标为(idx - 1) / 2。
     * 建堆的过程中，就是将元素不断插入。插入一个元素时，若该元素比父节点的值还大/小，就交换，直到满足堆的条件。
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
