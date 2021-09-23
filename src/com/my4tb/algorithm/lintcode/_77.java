package com.my4tb.algorithm.lintcode;

public class _77 {

    /**
     * 公共子序列，不一定连续
     *
     * 最优策略下，最长匹配子序列情况下，考虑A的最后一个字符和B的最后一个字符
     *  1. 如果二者的最后一个字符相同，问题规模可以缩小为，二者都砍掉最后一个字符后，最长匹配子序列
     *  2. 如果二者的最后一个字符不同，可以去看A砍掉一个字符后和B匹配，或B砍掉一个字符和A匹配
     *
     * 设f[i][j]为A的前i个字符和B的前j个字符的最长匹配子序列长度
     */
    private static int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() == 0 || B.length() == 0)
            return 0;
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();
        int lenA = charsA.length, lenB = charsB.length;
        int[][] f = new int[lenA + 1][lenB + 1];
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (charsA[i - 1] == charsB[j - 1])
                    f[i][j] = max(f[i - 1][j - 1] + 1, f[i - 1][j], f[i][j - 1]);
                else
                    f[i][j] = max(0, f[i - 1][j], f[i][j - 1]);
            }
        }
        return f[lenA][lenB];
    }

    private static int max(int a, int b, int c) {
        if (b >= a)
            a = b;
        if (c >= a)
            a = c;
        return a;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ABCD", "EACB"));
    }

}
