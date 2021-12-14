package com.my4tb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _119 {

    private static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0)
            return List.of(1);
        if (rowIndex == 1)
            return List.of(1, 1);

        int[][] f = new int[2][rowIndex + 1];
        int curr = 0;
        int pre;
        f[curr][0] = 1;
        f[curr][1] = 1;

        for (int i = 2; i <= rowIndex; i++) {
            pre = curr;
            curr = 1 - pre;
            f[curr][0] = 1;
            for (int j = 1; j < rowIndex; j++) {
                f[curr][j] = f[pre][j - 1] + f[pre][j];
            }
            f[curr][i] = 1;
        }

        return Arrays.stream(f[curr]).collect(ArrayList::new, List::add, List::addAll);
    }

    public static void main(String[] args) {
        System.out.println(getRow(0));
        System.out.println(getRow(1));
        System.out.println(getRow(2));
        System.out.println(getRow(3));
        System.out.println(getRow(4));
        System.out.println(getRow(5));
    }

}
