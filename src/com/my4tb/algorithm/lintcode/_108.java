package com.my4tb.algorithm.lintcode;

public class _108 {

    /**
     * 最优策略中，最后一个回文串是 s[i, j]，那么问题转化为 s[0, i - 1] 最少分割为几个回文串
     * 假设 f[i] 表示 s[0, i] 最少分割几次
     * 从 j = 0 遍历到 j = i - 1，在 s[j, i] 是回文串的前提下，取 f[j - 1] 的最小值
     * f[i] = 上述最小值 + 1
     * j = 0 是特殊情况，f[i] = 1，即 s[0, i] 本身就是回文串
     */
    private static int minCut(String s) {
        // write your code here
        if (s == null || s.length() <= 1)
            return 0;
        int[] f = new int[s.length()];
        f[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
                f[i] = 0;
                continue;
            }
            f[i] = s.length();
            for (int j = 1; j <= i; j++) {
                if (isPalindrome(s.substring(j, i + 1))) {
                    f[i] = Math.min(f[i], f[j - 1] + 1);
                }
            }
        }
        return f[s.length() - 1];
    }

    private static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (chars[i++] != chars[j--])
                return false;
        }
        return true;
    }

    private static int minCutOptimized(String s) {
        if (s == null || s.length() <= 1)
            return 0;
        boolean[][] palindromeState = getPalindromeState(s);
        int[] f = new int[s.length()];
        f[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (palindromeState[0][i]) {
                f[i] = 0;
                continue;
            }
            f[i] = s.length();
            for (int j = 1; j <= i; j++) {
                if (palindromeState[j][i])
                    f[i] = Math.min(f[j - 1] + 1, f[i]);
            }
        }
        return f[s.length() - 1];
    }

    /**
     * isPalindrome 方法会花费大量时间进行重复判断
     * 对于回文类问题，用中心扩展的方法记录子串是否是回文的状态，空间换时间
     */
    private static boolean[][] getPalindromeState(String s) {
        char[] chars = s.toCharArray();
        boolean[][] f = new boolean[chars.length][chars.length];
        int left = 0, right = 0;
        while (right < chars.length) {
            int i = left, j = right;
            while (i >= 0 && j < chars.length) {
                if (chars[i] == chars[j])
                    f[i--][j++] = true;
                else
                    break;
            }
            if (left == right)
                right++;
            else
                left++;
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(minCutOptimized("abccb"));
    }

}
