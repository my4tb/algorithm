package com.my4tb.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _42 {

    public int trap(int[] height) {
        if (height == null || height.length <= 2)
            return 0;

        Deque<Integer> stack = new LinkedList<>() {
            {
                if (height[0] > height[1])
                    push(height[0]);
                push(height[1]);
            }
        };

        int rst = 0;

        for (int i = 2; i < height.length; i++) {
            int h = height[i];
            if (h > stack.peek()) {

            } else {
                stack.push(h);
            }
        }

        return rst;
    }

    public static void main(String[] args) {

    }

}
