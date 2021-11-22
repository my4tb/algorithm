package com.my4tb.algorithm.leetcode;

public class _72 {

    private static int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();

        if (len1 == 0)
            return len2;
        if (len2 == 0)
            return len1;

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] f = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0)
                    f[i][j] = j;
                else if (j == 0)
                    f[i][j] = i;
                else {
                    if (chars1[i - 1] == chars2[j - 1])
                        f[i][j] = f[i - 1][j - 1];
                    else {
                        int min = min(f[i - 1][j - 1], f[i][j - 1], f[i - 1][j]);
                        f[i][j] = min + 1;
                    }
                }
            }
        }

        return f[len1][len2];
    }

    private static int minDistanceOptimized(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();

        if (len1 == 0)
            return len2;
        if (len2 == 0)
            return len1;

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] f = new int[2][len2 + 1];
        int now = 0, pre;

        for (int i = 0; i <= len1; i++) {
            pre = now;
            now = 1 - pre;
            for (int j = 0; j <= len2; j++) {
                if (i == 0)
                    f[now][j] = j;
                else if (j == 0)
                    f[now][j] = i;
                else {
                    if (chars1[i - 1] == chars2[j - 1])
                        f[now][j] = f[pre][j - 1];
                    else {
                        int min = min(f[pre][j - 1], f[now][j - 1], f[pre][j]);
                        f[now][j] = min + 1;
                    }
                }
            }
        }

        return f[now][len2];
    }

    private static int min(int a, int b, int c) {
        if (b < a)
            a = b;
        if (c < a)
            a = c;
        return a;
    }

    public static void main(String[] args) {
        System.out.println(minDistanceOptimized("horse", "ros"));
        System.out.println(minDistanceOptimized("intention", "execution"));
    }

}
