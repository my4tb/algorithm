package com.my4tb.algorithm.lintcode;

import java.util.Arrays;

public class _394 {

    /**
     * 博弈型动态规划，两个重要概念：
     *  1. 必胜，己方走完当前一步（选择最优策略），对方必输
     *  2. 必败，己方走完当前一步（不论如何选择），对方必胜
     *
     * 设f[i]表示有i个棋子时，先手的人是否必胜，则f[i] = !(f[i - 1] && f[i - 2])
     * 也就是说，无论拿1个还是2两棋子，下一次对方先手都必胜，那么当前i个棋子先手的人必败
     * 拿1个或者拿2个棋子，只要有一种方式能使下一次对方现手必败，那么当前i个棋子先手人必胜
     *
     * 初始化，f[0] = false, f[1] = true, f[2] = true
     *
     * 本地得出的数组f有规律，比如n=10时，f=[false, true, true, false, true, true, false, true, true, false, true]
     * 可以看到n=0、3、6、9时为false，即n % 3 != 0时，必胜
     */
    private static boolean firstWillWin(int n) {
        // write your code here
        if (n == 0)
            return false;
        if (n == 1)
            return true;
        boolean[] f = new boolean[n + 1];
        f[1] = true;
        for (int i = 2; i <= n; i++) {
            f[i] = !(f[i - 1] && f[i - 2]);
        }
        System.out.println(Arrays.toString(f));
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(firstWillWin(10));
    }

}
