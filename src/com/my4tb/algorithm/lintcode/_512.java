package com.my4tb.algorithm.lintcode;

public class _512 {

    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public static int numDecodings(String s) {
        // write your code here
        if (s == null || s.equals("") || s.equals("0"))
            return 0;
        if (s.length() == 1)
            return 1;
        int[] status = new int[s.length() + 1];
        status[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            char currC = s.charAt(i - 1);
            if (currC == '0') {
                // 当前字符为'0'时，只能和前面字符组合
                // 如果不合法，那么返回0
                // 如果合法，status[i] = status[i - 2]
                if (i < 2)
                    return 0;
                char c = s.charAt(i - 2);
                int num = Integer.parseInt(String.valueOf(c) + currC);
                if (num > 0 && num <= 26)
                    status[i] = status[i - 2];
                else
                    return 0;
            } else {
                status[i] = status[i - 1];
                char c;
                if (i < 2 || (c = s.charAt(i - 2)) == '0')
                    continue;
                int num = Integer.parseInt(String.valueOf(c) + currC);
                if (num <= 26)
                    status[i] += status[i - 2];

            }
        }
        return status[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("101"));
    }

}
