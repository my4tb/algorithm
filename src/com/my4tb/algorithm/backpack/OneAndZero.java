package com.my4tb.algorithm.backpack;

/**
 * leetcode 474 有两个维度的容量 价值为1
 */
public class OneAndZero {

    public static void main(String[] args) {
        OneAndZero oneAndZero = new OneAndZero();
//        System.out.println(oneAndZero.findMaxForm(new String[] {"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(oneAndZero.findMaxForm(new String[] {"10", "0", "1"}, 1, 1));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] f = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] counts = count0And1(str);
            for (int i = m; i >= counts[0]; i--)
                for (int j = n; j >= counts[1]; j--)
                    f[i][j] = Math.max(f[i][j], f[i - counts[0]][j - counts[1]] + 1);
        }
        return f[m][n];
    }

    private int[] count0And1(String str) {
        int[] counts = new int[2];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - '0']++;
        }
        return counts;
    }

}
