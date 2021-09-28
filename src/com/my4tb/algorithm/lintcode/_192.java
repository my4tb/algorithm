package com.my4tb.algorithm.lintcode;

public class _192 {

    private static boolean isMatch(String s, String p) {
        // write your code here
        char[] charsS = s.toCharArray();
        char[] charsP = p.toCharArray();
        int lenS = charsS.length, lenP = charsP.length;

        boolean[][] f = new boolean[lenS + 1][lenP + 1];
        for (int i = 0; i <= lenS; i++) {
            for (int j = 0; j <= lenP; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = true;
                } else if (j == 0) {
                    f[i][j] = false;
                } else if (i == 0) {
                    if (charsP[j - 1] == '*') {
                        f[i][j] = f[i][j - 1];
                    }
                } else {
                    char curr = charsP[j - 1];
                    if (curr == '*') {
                        f[i][j] = f[i - 1][j] || f[i][j - 1];
                    } else if (curr == '?') {
                        f[i][j] = f[i - 1][j - 1];
                    } else {
                        if (curr == charsS[i - 1]) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    }
                }
            }
        }

        return f[lenS][lenP];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("ab", "?*"));
    }

}
