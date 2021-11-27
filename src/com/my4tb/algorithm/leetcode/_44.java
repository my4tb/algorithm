package com.my4tb.algorithm.leetcode;

import java.util.Arrays;

public class _44 {

    private static boolean isMatch(String s, String p) {
        int ls = s.length(), lp = p.length();
        char[] ss = s.toCharArray(), ps = p.toCharArray();

        boolean[][] f = new boolean[2][lp + 1];

        int now = 0, pre;

        for (int i = 0; i <= ls; i++) {
            pre = now;
            now = 1 - pre;
            for (int j = 0; j <= lp; j++) {
                if (i == 0 && j == 0)
                    f[now][j] = true;
                else if (i == 0) {
                    if (ps[j - 1] == '*')
                        f[now][j] = f[now][j - 1];
                    else
                        f[now][j] = false;
                } else if (j == 0) {
                    f[now][j] = false;
                } else {
                    char currP = ps[j - 1];
                    switch (currP) {
                        case '*':
                            f[now][j] = f[pre][j] || f[now][j - 1];
                            break;
                        case '?':
                            f[now][j] = f[pre][j - 1];
                            break;
                        default:
                            if (currP == ss[i - 1])
                                f[now][j] = f[pre][j - 1];
                            else
                                f[now][j] = false;
                            break;
                    }
                }
            }
        }

        return f[now][lp];
    }

    public static void main(String[] args) {
//        System.out.println(isMatch("aa", "a"));
//        System.out.println(isMatch("aa", "a?*"));
//        System.out.println(isMatch("adceb", "*a*b"));
//        System.out.println(isMatch("acdcb", "a*c?b"));
        System.out.println(isMatch("baa", "a*"));
    }

}
