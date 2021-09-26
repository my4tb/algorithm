package com.my4tb.algorithm.lintcode;

public class _118 {

    /**
     * S中包含多少个T
     * 仍然比较最后一个字符，分为如下情况：
     * 1. 最后一个字符相同，那么砍掉S和T的最后一个字符，继续匹配
     * 2. 最后一个字符不同，那么砍掉S的最后一个字符，T和S砍掉最后一个字符去匹配即可
     * 需要注意的是，即使最后一个字符相同，T可以选择和当前S匹配，也可以选择和砍掉最后一个字符的S去匹配
     * 因此，上述两种情况要同时统计
     * <p>
     * f[i][j]表示S的前i个字符和T的前j个字符的匹配次数
     */
    private static int numDistinct(String S, String T) {
        // write your code here
        char[] charsS = S.toCharArray();
        char[] charsT = T.toCharArray();
        int lenS = S.length(), lenT = T.length();
        if (lenS < lenT)
            return 0;
        int[][] f = new int[lenS + 1][lenT + 1];
        for (int i = 0; i <= lenS; i++) {
            for (int j = 0; j <= lenT; j++) {
                if (i == 0 && j != 0)
                    f[i][j] = 0;
                else if (j == 0)
                    f[i][j] = 1;
                else {
                    f[i][j] = f[i - 1][j];
                    if (charsS[i - 1] == charsT[j - 1])
                        f[i][j] += f[i - 1][j - 1];
                }
            }
        }
        return f[lenS][lenT];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }

}
