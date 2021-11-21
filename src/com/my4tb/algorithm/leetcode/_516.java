package com.my4tb.algorithm.leetcode;

public class _516 {

    private static int longestPalindromeSubSeq(String s) {
        int len = s.length();

        if (len == 0)
            return 0;

        char[] chars = s.toCharArray();
        int[][] f = new int[len][len];

        for (int l = 1; l <= len; l++) {
            int j;
            for (int i = 0; (j = i + l - 1) < len; i++) {
                if (l == 1) {
                    f[i][j] = 1;
                }
                else if (chars[i] == chars[j]) {
                    if (l == 2) {
                        f[i][j] = 2;
                    } else {
                        f[i][j] = max(f[i + 1][j - 1] + 2, f[i + 1][j], f[i][j - 1]);
                    }
                } else {
                    if (l == 2) {
                        f[i][j] = 1;
                    }
                    else {
                        f[i][j] = max(0, f[i + 1][j], f[i][j - 1]);
                    }
                }
            }
        }

        return f[0][len - 1];
    }

    private static int max(int a, int b, int c) {
        if (b > a)
            a = b;
        if (c > a)
            a = c;
        return a;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubSeq("a"));
        System.out.println(longestPalindromeSubSeq("abcd"));
    }

}
