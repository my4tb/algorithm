package com.my4tb.algorithm.lintcode;

public class _108 {

    /**
     * 划分成一些子串，划分型动态规划
     * last step, 最优策略中，最后一段回文串是s[i, len(s) - 1]，那么s[0, i - 1]一定也能被最少次数划分
     * 设 f[i] 表示前 s[0, i] 划分的最少次数
     * 遍历 j 属于 [0, i - 1]，在 s[j + 1, i] 是回文串的前提下，寻找最小 f[j]，则 f[i] = f[j] + 1
     */
    private static int minCut(String s) {
        // write your code here
        if (s == null || s.length() <= 1)
            return 0;
        int[] f = new int[s.length()];
        f[0] = 0;
        // abc
        for (int i = 1; i < s.length(); i++) {
            f[i] = s.length();
            if (isPalindrome(s.substring(0, i + 1))) {
                f[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (!isPalindrome(s.substring(j + 1, i + 1)))
                    continue;
                f[i] = Math.min(f[i], f[j] + 1);
            }
        }
        return f[s.length() - 1];
    }

    private static boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (chars[i++] != chars[j--])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minCut("abab"));
    }

}
