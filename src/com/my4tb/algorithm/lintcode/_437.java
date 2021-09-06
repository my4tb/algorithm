package com.my4tb.algorithm.lintcode;

public class _437 {

    /**
     * 问题描述：将数组pages最多划分为k段，求每一段sum的最大值
     * 假设最优策略中，第k个人，即最后一个人，抄写pages[j, pages.length - 1]区间的书，
     * 其中j取值范围为[0, pages.length - 1]
     * 那么前k - 1个人应该抄写pages[0, j - 1]区间的书
     * 设f[k][i]表示k个人抄下标为前i本书的最短用时
     * f[0][i] = +infinity，即0个人无法抄写
     * f[k][0] = 0，抄0本书需要时间为0
     *
     * 最终结果f[k][pages.length - 1]
     */
    private static int copyBooks(int[] pages, int k) {
        // write your code here
        if (k <= 0 || pages == null || pages.length == 0)
            return 0;
        int[][] f = new int[k + 1][pages.length + 1];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= pages.length; j++) {
                if (j == 0)
                    f[i][j] = 0;
                else if (i == 0)
                    f[i][j] = Integer.MAX_VALUE;
                else {
                    int sum = 0; // 记录第i个人抄t本书的时间
                    int min = Integer.MAX_VALUE;
                    for (int t = 0; t <= j; t++) {
                        if (t > 0)
                            sum += pages[j - t];
                        // 首先找出最长用时，即当第i个人抄t本书，前i-1个人抄pages.length-t本书时的最长用时（短板）
                        // 需要考虑第i个人抄[0, j]本书的情况，并取所有短板值的最小值
                        min = Math.min(min, Math.max(sum, f[i - 1][j - t]));
                    }
                    f[i][j] = min;
                }
            }
        }
        return f[k][pages.length];
    }

    public static void main(String[] args) {
        System.out.println(copyBooks(new int[]{3, 2, 4}, 3));
    }

}
