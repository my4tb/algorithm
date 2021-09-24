package com.my4tb.algorithm.lintcode;

public class _119 {

    /**
     * 双序列类型动态规划
     *
     * word1和word2最后一个字符分别为第i和第j个字符
     * 分为两大类：
     *  1. 前者第i个字符和后者第j个字符相同，只需分别砍掉最后一个字符，
     *  看前者前i-1个字符最少经过多少次操作得到后者前j-1个字符即可
     *  2. 前者第i个字符和后者第j个字符不同，细分如下：
     *      a. 替换前者第i个字符与后者第j个字符相同，然后砍掉
     *      b. 砍掉前者的最后一个字符，看前者前i-1个字符最少经过多少次操作后匹配到后者的前j个字符
     *      c. 为前者插入一个字符与后者的最后一个字符匹配，然后看前者前i个字符最少经过多少次操作后匹配到后者的前j-1个字符
     */
    private static int minDistance(String word1, String word2) {
        // write your code here
        if (word1.equals(word2))
            return 0;

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int len1 = chars1.length, len2 = chars2.length;

        int[][] f = new int[len1 + 1][len2 + 2];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 && j == 0)
                    f[i][j] = 0; // 不许要操作
                else if (i == 0)
                    f[i][j] = j; // 插入j个字符
                else if (j == 0)
                    f[i][j] = i; // 删除i个字符
                else {
                    if (chars1[i - 1] == chars2[j - 1])
                        f[i][j] = f[i - 1][j - 1]; // 砍掉最后一个字符即可
                    else {
                        int a = f[i - 1][j - 1]; // 替换最后一个字符，然后砍掉
                        int b = f[i][j - 1]; // 插入一个相同的字符，然后砍掉
                        int c = f[i - 1][j]; // 砍掉最后一个字符，然后继续匹配
                        f[i][j] = min(a, b, c) + 1;
                    }
                }
            }
        }

        return f[len1][len2];
    }

    private static int min(int a, int b, int c) {
        if (a > b)
            a = b;
        if (a > c)
            a = c;
        return a;
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
    }

}
