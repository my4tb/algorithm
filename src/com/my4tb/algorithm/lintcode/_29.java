package com.my4tb.algorithm.lintcode;

public class _29 {

    /**
     * 同77，在最优策略中，考虑逐渐砍掉在最后一个字符，缩小问题规模
     *
     * f[i][j]表示s1的前i个字符和s2的前j个字符能否交叉拼出s3的前i+j个字符
     */
    private static boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        int len1 = s1.length(), len2 = s2.length();
        if (len1 + len2 != s3.length())
            return false;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();
        boolean[][] f = new boolean[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) { // chars1
            for (int j = 0; j <= len2; j++) { // chars2
                if (i == 0 && j == 0) // 初始
                    f[i][j] = true;
                else if (i == 0) { // 初始
                    if (chars2[j - 1] == chars3[j - 1])
                        f[i][j] = f[i][j - 1];
                } else if (j == 0) { // 初始
                    if (chars1[i - 1] == chars3[i - 1])
                        f[i][j] = f[i - 1][j];
                } else {
                    if (chars1[i - 1] != chars3[i + j - 1] && chars2[j - 1] != chars3[i + j - 1]) // 二者最后一个字符都不与s3最后一个字符相同
                        f[i][j] = false;
                    else if (chars1[i - 1] == chars3[i + j - 1] && chars2[j - 1] == chars3[i + j - 1]) // 二者最后字符都与s3最后一个字符相同
                        f[i][j] = f[i - 1][j] || f[i][j - 1];
                    else { // 只有一个相同
                        if (chars1[i - 1] == chars3[i + j - 1])
                            f[i][j] = f[i - 1][j];
                        else if (chars2[j - 1] == chars3[i + j - 1])
                            f[i][j] = f[i][j - 1];
                    }
                }
            }
        }
        return f[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aacaac", "aacaaeaac", "aacaaeaaeaacaac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

}
