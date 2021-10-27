package com.my4tb.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _402 {

    private static String removeKDigits(String num, int k) {
        char[] nums = num.toCharArray();
        int left = nums.length; // 记录剩余未遍历元素数目
        int minNum = left - k; // 记录最少应有的元素数
        Deque<Character> stack = new LinkedList<>();
        for (char n : nums) {
            while (!stack.isEmpty() && stack.peek() > n && left > minNum) {
                stack.pop();
                left--;
            }
            stack.push(n);
        }

        while (stack.size() > minNum)
            stack.pop();

        StringBuilder rst = new StringBuilder();
        while (!stack.isEmpty())
            rst.append(stack.pollLast());

        while (rst.length() != 0 && rst.charAt(0) == '0')
            rst.deleteCharAt(0);

        return rst.length() == 0 ? "0" : rst.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKDigits("1432219", 3));
        System.out.println(removeKDigits("10200", 1));
        System.out.println(removeKDigits("10", 2));
        System.out.println(removeKDigits("10000", 1));
        System.out.println(removeKDigits("10001", 4));
    }

}
