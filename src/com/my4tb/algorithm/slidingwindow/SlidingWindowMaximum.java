package com.my4tb.algorithm.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * leetcode 239
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] result = slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(result));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 0 || nums == null || nums.length < k)
            return new int[0];
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 保证队列中严格递增
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()])
                deque.removeLast();
            deque.addLast(i);
            // 保证队列中元素不超过k个
            if (deque.getFirst() == i - k)
                deque.removeFirst();
            // 保证前k个元素滑动过去
            if (i >= k - 1)
                result[i - k + 1] = nums[deque.getFirst()];
        }
        return result;
    }

}
