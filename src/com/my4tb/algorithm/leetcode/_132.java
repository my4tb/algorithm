package com.my4tb.algorithm.leetcode;

import java.util.Arrays;

public class _132 {

    private static int minCut(String s) {
        if (s.length() <= 1)
            return 0;

        int len = s.length();
        boolean[][] state = palindromeState(s);
        int[] f = new int[len];
        for (int i = 1; i < len; i++) {
            if (state[0][i])
                f[i] = 0;
            else {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++)
                    if (state[j + 1][i])
                        min = Math.min(min, f[j]);
                f[i] = min + 1;
            }
        }

        return f[len - 1];
    }

    private static boolean[][] palindromeState(String str) {
        int len = str.length();
        boolean[][] f = new boolean[len][len];
        int l = 0, r = 0;
        while (r < len) {
            for (int i = l, j = r; i >= 0 && j < len; i--, j++) {
                if (i == j)
                    f[i][j] = true;
                else if (str.charAt(i) == str.charAt(j))
                    f[i][j] = true;
                else
                    break;
            }
            if (l == r)
                r++;
            else
                l++;
        }
        return f;
    }

    public static void main(String[] args) {
        boolean[][] palindromeState = palindromeState("aaba");
        for (boolean[] s : palindromeState)
            System.out.println(Arrays.toString(s));

        System.out.println(minCut("abc"));
    }

}
