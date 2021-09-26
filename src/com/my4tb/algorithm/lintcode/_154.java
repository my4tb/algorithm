package com.my4tb.algorithm.lintcode;

public class _154 {

    private static boolean isMatch(String s, String p) {
        // write your code here
        int lenS = s.length(), lenP = p.length();
        char[] charsS = s.toCharArray();
        char[] charsP = p.toCharArray();
        boolean[][] f = new boolean[lenS + 1][lenP + 1];
        for (int i = 0; i <= lenS; i++) {
            for (int j = 0; j <= lenP; j++) {
                if (i == 0 && j == 0)
                    f[i][j] = true;
                else if (j == 0)
                    f[i][j] = false;
                else { // s有0到多个字符，p有多个字符
                    char c_p = charsP[j - 1];
                    if (c_p == '*') {
                        if (j > 1) { // *前面必须有字符
                            if (i == 0) {
                                f[i][j] = f[i][j - 2];
                                continue;
                            }
                            char c_p_pre = charsP[j - 2];
                            if (c_p_pre == '.') {
                                f[i][j] = f[i][j - 2] || f[i - 1][j];
                            } else {
                                f[i][j] = f[i][j - 2];
                                if (charsS[i - 1] == c_p_pre)
                                    f[i][j] = f[i][j] || f[i - 1][j];
                            }
                        }
                    } else if (c_p == '.') {
                        if (i > 0)
                            f[i][j] = f[i - 1][j - 1];
                    } else {
                        if (i > 0 && charsS[i - 1] == charsP[j - 1]) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    }
                }
            }
        }
        return f[lenS][lenP];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "c.*"));
    }

}
