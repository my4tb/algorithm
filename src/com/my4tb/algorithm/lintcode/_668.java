package com.my4tb.algorithm.lintcode;

public class _668 {

    /**
     * 考虑最优策略中，是否包含最后一个01串：
     * 1. 包含
     * 2. 不含
     * 由于是01串，因此需要分别记录0和1的状态
     * 所以有f[i][j][k]表示前i个01串中，j个0，k个1，最多能够组成多少个
     * <p>
     * 己住，与之前题目不同的是，这种题目需要分别记录0和1的状态
     */
    private static int findMaxForm(String[] strs, int m, int n) {
        // write your code here
        if (strs == null || strs.length == 0)
            return 0;

        int len = strs.length;
        int[][][] f = new int[len + 1][m + 1][n + 1];
        for (int i = 1; i <= len; i++) { // 前0个01串可以组成0个
            int count0 = count0(strs[i - 1]);
            int count1 = strs[i - 1].length() - count0;
            for (int j = 0; j <= m; j++) { // 0
                for (int k = 0; k <= n; k++) { // 1
                    f[i][j][k] = f[i - 1][j][k];
                    if (j >= count0 && k >= count1)
                        f[i][j][k] = Math.max(f[i][j][k], f[i - 1][j - count0][k - count1] + 1); // 第一维度只取i-1，优化
                }
            }
        }

        return f[len][m][n];
    }

    private static int count0(String str) {
        char[] chars = str.toCharArray();
        int rst = 0;
        for (char c : chars)
            if (c == '0')
                rst++;
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 7, 7));
    }

}
