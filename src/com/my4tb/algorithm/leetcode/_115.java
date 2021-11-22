package com.my4tb.algorithm.leetcode;

public class _115 {

    private static int numDistinct(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if (lenS < lenT)
            return 0;

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        int[][] f = new int[2][lenT + 1];
        int now = 0, pre;

        for (int i = 0; i <= lenS; i++) {
            pre = now;
            now = 1 - pre;
            for (int j = 0; j <= i && j <= lenT; j++) {
                if (j == 0)
                    f[now][j] = 1;
                else {
                    if (ss[i - 1] == tt[j - 1])
                        f[now][j] = f[pre][j - 1] + f[pre][j];
                    else
                        f[now][j] = f[pre][j];
                }
            }
        }

        return f[now][lenT];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("babgbag", "bag"));
        System.out.println(numDistinct("aaa", "aa"));
    }

}
