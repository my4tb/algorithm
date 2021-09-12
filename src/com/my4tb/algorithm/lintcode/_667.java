package com.my4tb.algorithm.lintcode;

public class _667 {

    /**
     * 区间型动态规划
     *  1. 不能以其它类型动态规划的计算顺序去做，而是以长度从1到length的顺序
     *  2. 按照长度初始化状态数组
     *
     * 从题意出发
     *  本地组成回文串的方式不一定连续
     *  最后一步，假设最长回文串的最后两个字符是chars[i] & chars[j]，一定有chars[i] = chars[j]
     *  则，f[i][j] = max(2 + f[i + 1][j - 1], f[i + 1][j], f[i][j - 1])
     *
     * 可以看到，当前计算的区间长度是依赖更短区间长度的，对应顶部所说计算顺序需要按照长度从小到大来
     */
    private static int longestPalindromeSubSeq(String s) {
        // write your code here
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;
        char[] chars = s.toCharArray();
        int[][] f = new int[chars.length][chars.length];
        for (int len = 1; len <= chars.length; len++) { // 区间型动态规划利用长度计算
            for (int start = 0; start <= chars.length - len; start++) {
                int end = start + len - 1;
                if (len == 1)
                    f[start][end] = 1;
                else if (len == 2)
                    if (chars[start] == chars[end])
                        f[start][end] = 2;
                    else
                        f[start][end] = 1;
                else if (chars[start] == chars[end])
                    f[start][end] = max(
                            f[start + 1][end - 1] + 2,
                            f[start + 1][end],
                            f[start][end - 1]);
                else
                    f[start][end] = max(
                            0,
                            f[start + 1][end],
                            f[start][end - 1]);

            }
        }
        return f[0][chars.length - 1];
    }

    private static int max(int a, int b, int c) {
        if (a < b)
            a = b;
        if (a < c)
            a = c;
        return a;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubSeq("aaaaa"));
    }

}
