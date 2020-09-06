package com.my4tb.algorithm.nqueen;

import java.util.Arrays;

/**
 * 返回所有解决方案
 */
public class NQueens {

    private int count = 0;

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.totalNQueens(1));
    }

    private int totalNQueens(int n) {
        int[] position = new int[n];
        Arrays.fill(position, -1);
        dfs(0, n, position);
        return count;
    }

    private void dfs(int row, int n, int[] position) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            boolean ok = true;
            for (int i = 0; i < row; i++) {
                if (position[i] == col || col + row == position[i] + i || col - row == position[i] - i) {
                    ok = false;
                    break;
                }
            }
            if (!ok)
                continue;
            position[row] = col;
            dfs(row + 1, n, position);
            position[row] = -1;
        }
    }

}
