package com.my4tb.algorithm.lintcode;

public class _430 {

    private static boolean isScramble(String s1, String s2) {
        // write your code here
        if (s1 == null && s2 == null)
            return true;
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;

        int length = s1.length();
        boolean[][][][] f = new boolean[length][length][length][length];

        for (int len = 1; len <= length; len++) {
            for (int i = 0; i < length; i++) { // s1起始位置
                for (int j = 0; j < length; j++) { // s2起始位置
                    if (i + len > length || j + len > length)
                        break;
                    if (len == 1) {
                        if (s1.charAt(i) == s2.charAt(j))
                            f[i][i][j][j] = true;
                    } else {
                        for (int l = 1; l < len; l++) {
                            int end_i = i + l - 1;
                            int end_j = j + l - 1;
                            if (f[i][end_i][j][end_j] && f[end_i + 1][i + len - 1][end_j + 1][j + len - 1]) {
                                f[i][i + len - 1][j][j + len - 1] = true;
                                break;
                            }
                            if (f[i][i + l - 1][j + len - l][j + len - 1] && f[i + len - l - 1][i + len - 1][j][j + l - 1]) {
                                f[i][i + len - 1][j][j + len - 1] = true;
                                break;
                            }
                        }
                    }

                }
            }
        }

        return f[0][length - 1][0][length - 1];
    }

    public static void main(String[] args) {
        System.out.println(isScramble("abc", "bca"));
    }

}
