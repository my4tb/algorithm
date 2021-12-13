package com.my4tb.algorithm.leetcode;

public class _10 {

    private static boolean isMatch(String s, String p) {
        int lenS = s.length(), lenP = p.length();
        char[] ss = s.toCharArray(), pp = p.toCharArray();

        boolean[][] f = new boolean[lenS + 1][lenP + 1];

        for (int i = 0; i <= lenS; i++) {
            for (int j = 0; j <= lenP; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = true;
                } else if (j == 0) {
                    f[i][j] = false;
                } else {
                    char currP = pp[j - 1];
                    switch (currP) {
                        case '*':
                            if (j == 1) // *不能作为第一个字符
                                return false;
                            char preP = pp[j - 2];
                            if (preP == '*') { // 两个*不能连一起
                                return false;
                            } else if (preP == '.') {
                                if (i == 0) {
                                    f[i][j] = f[i][j - 2];
                                } else {
                                    f[i][j] = f[i][j - 2] || f[i - 1][j];
                                }
                            } else { // preP is a case
                                if (i == 0) {
                                    f[i][j] = f[i][j - 2];
                                } else {
                                    f[i][j] = f[i][j - 2];
                                    if (preP == ss[i - 1])
                                        f[i][j] = f[i][j] || f[i - 1][j];
                                }
                            }
                            break;
                        case '.':
                            if (i > 0) {
                                f[i][j] = f[i - 1][j - 1];
                            }
                            break;
                        default: // case
                            if (i > 0) {
                                if (ss[i - 1] == currP) {
                                    f[i][j] = f[i - 1][j - 1];
                                }
                            }
                    }
                }
            }
        }

        return f[lenS][lenP];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("", ""));
        System.out.println(isMatch("", ".*"));
        System.out.println(isMatch("", "a.*"));
        System.out.println(isMatch("aa", ".*"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
    }

}









