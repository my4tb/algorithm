package com.my4tb.algorithm.leetcode;

import java.util.Arrays;

public class _97 {

    private static boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3)
            return false;

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();

        // s1的前len1个字符和s2的前len2个字符能否组成s3的前len1+len2个字符
        boolean[][] f = new boolean[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) { // s1 chars1
            for (int j = 0; j <= len2; j++) { // s2 chars2
                if (i == 0 && j == 0) {
                    f[i][j] = true;
                } else if (i == 0) {
                    if (chars2[j - 1] != chars3[j - 1])
                        f[i][j] = false;
                    else
                        f[i][j] = f[i][j - 1];
                } else if (j == 0) {
                    if (chars1[i - 1] != chars3[i - 1])
                        f[i][j] = false;
                    else
                        f[i][j] = f[i - 1][j];
                } else {
                    char curr = chars3[i + j - 1];
                    if (chars1[i - 1] != curr && chars2[j - 1] != curr)
                        f[i][j] = false;
                    else if (chars1[i - 1] == curr && chars2[j - 1] == curr)
                        f[i][j] = f[i][j - 1] || f[i - 1][j];
                    else if (chars1[i - 1] == curr)
                        f[i][j] = f[i - 1][j];
                    else if (chars2[j - 1] == curr)
                        f[i][j] = f[i][j - 1];
                }
            }
        }

        return f[len1][len2];
    }

    public static void main(String[] args) {
//        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
//        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(isInterleave("aabc", "abad", "aabadabc"));
    }

}
