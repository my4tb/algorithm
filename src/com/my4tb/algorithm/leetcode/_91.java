package com.my4tb.algorithm.leetcode;

public class _91 {

    private static int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;

        int len = s.length();

        // f[i]表示以下标i为结尾的解码方式数
        int[] f = new int[len];
        f[0] = 1;
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            char preC = s.charAt(i - 1);
            if (c == '0') {
                if (preC == '0' || preC > '2')
                    return 0;
                if (i == 1)
                    f[i] = 1;
                else
                    f[i] = f[i - 2];
            } else {
                f[i] = f[i - 1];
                if (preC != '0') {
                    int num = (preC - '0') * 10 + (c - '0');
                    if (num <= 26)
                        if (i == 1)
                            f[i] += 1;
                        else
                            f[i] += f[i - 2];
                }
            }
        }

        return f[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("06"));
    }

}
