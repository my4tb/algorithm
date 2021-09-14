package com.my4tb.algorithm.lintcode;

public class _396 {

    /**
     * 最初先手拿第一枚棋子时面临的问题：如何才能获取本局游戏的最大值
     * 当最初先手拿完后，第二手拿棋子的人同样面临着相同的问题，即如何获取本局游戏的最大值
     * 与最初先手不同的是，第二手拿棋子的人面临的棋子数少了一个[子问题]
     *
     * 假设第一手拿棋子的人，n个棋子时，能够得到的最大值为T
     * 第二手拿棋子的人，n-1个棋子时，能够得到的最大值为Z
     * 对于第一手拿旗子的人，他的目标就是T >= Z，等价于目标是 S = T - Z >= 0
     *
     * 我们可以记录f[i][j]，表示下标为i到下标为j的棋子时，先手的人能够获得的最大价值与次先手的人获得最大价值的差S
     * 此时先手的人可以拿下标为i的棋子，也可以拿下标为j的棋子
     * 假设拿下标为i的棋子，下标为i的棋子的价值为m，那么当前S值为？
     *
     * 结论：S^curr = m - S^next
     * 其中，S^curr表示当前先手与次先手最大值差，m表示当前先手拿的棋子的值，S^next表示次先手与再次先手最大值差
     *
     * 推导：
     * 设当前先手拿的棋子价值为m，最大值为T，次先手最大值为Z，再次先手最大值为W，则有
     * S^curr = T - Z
     * S^next = Z - W
     * ->
     * S^curr + S^next = T - Z + Z - W = T - W
     * T、W恰好为同一个人第一次做先手和第二次做先手的最大价值，当前先手拿棋子价值为m时，与再次先手得到的最大价值W[子问题]之和，恰好为T
     * 上述，即 T = m + W -> m = T - W -> S^curr + S^next = m -> S^curr = m - S^next
     *
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

        return f[0][values.length - 1] >= 0;
    }

    public static void main(String[] args) {
        System.out.println(firstWillWin(new int[]{1, 20, 4}));
    }

}
