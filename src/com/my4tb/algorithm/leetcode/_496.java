package com.my4tb.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _496 {

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] rst = new int[nums1.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            int curr = nums2[i];
            while (!stack.isEmpty() && stack.peek() <= curr)
                stack.pop();
            map.put(curr, stack.isEmpty() ? -1 : stack.peek());
            stack.push(curr);
        }
        for (int i = 0; i < nums1.length; i++)
            rst[i] = map.get(nums1[i]);
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }

}
