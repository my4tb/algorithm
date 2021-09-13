package com.my4tb.algorithm.lintcode;

public class _396 {

    /**
     * 最初先手拿第一枚棋子时面临的问题：如何才能获取本局游戏的最大值
     * 当最初先手拿完后，第二手拿棋子的人同样面临着相同的问题，即如何获取本局游戏的最大值
     * 与最初先手不同的是，第二手拿棋子的人面临的棋子数少了一个[子问题]
     */
    private static boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0)
            return false;
        if (values.length == 1)
            return true;

        // f[i][j]表示从i到j下标区间的棋子，当前先手能够获得的最大值与下一步先手能够获得的最大值之差
        int[][] f = new int[values.length][values.length];
        for (int len = 1; len <= values.length; len++) {
            for (int start = 0; start < values.length; start++) {
                int end = start + len - 1;
                if (end >= values.length)
                    break;
                if (start == end)
                    f[start][end] = values[start];
                else if (start + 1 == end)
                    f[start][end] = Math.max(values[start], values[end]);
                else {
                    int takeLDiff = values[start] - f[start + 1][end];
                    int takeRDiff = values[end] - f[start][end - 1];
                    f[start][end] = Math.max(takeLDiff, takeRDiff);
                }
            }
        }

        return f[0][values.length - 1] > 0;
    }

    public static void main(String[] args) {
        System.out.println(firstWillWin(new int[]{1, 20, 4}));
    }

}
