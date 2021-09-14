package com.my4tb.algorithm.lintcode;

public class _395 {

    private static boolean firstWillWin(int[] values) {
        // write your code here
        if (values.length <= 2)
            return true;

        int len = values.length;
        int[] f = new int[len];
        f[len - 1] = values[len - 1];
        f[len - 2] = values[len - 1] + values[len - 2];

        for (int i = len - 3; i >= 0; i--) {
            int takeOne = values[i] - f[i + 1];
            int takeTwo = values[i] + values[i + 1] - f[i + 2];
            f[i] = Math.max(takeOne, takeTwo);
        }

        return f[0] >= 0;
    }

    public static void main(String[] args) {
        System.out.println(firstWillWin(new int[] {1, 2, 4}));
    }

}
