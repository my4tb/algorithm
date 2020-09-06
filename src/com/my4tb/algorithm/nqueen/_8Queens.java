package com.my4tb.algorithm.nqueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _8Queens {

    public static void main(String[] args) {
        _8Queens queens = new _8Queens();
        int n = 8;
        List<List<String>> result = queens.solveNQueens(n);
        System.out.println("result.size() = " + result.size());
        result.forEach(r -> r.forEach(System.out::println));
    }

    private List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] position = new int[n];
        Arrays.fill(position, -1);
        dfs(0, n, position, result);
        return result;
    }

    /*
        row表示当前向第几行放置皇后
     */
    private void dfs(int row, int n, int[] position, List<List<String>> result) {
        if (row == n) {
            List<String> r = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[position[i]] = 'Q';
                r.add(new String(chars));
            }
            result.add(r);
            return;
        }
        for (int col = 0; col < n; col++) { // 尝试当前行的每一列
            boolean ok = true;
            for (int i = 0; i < row; i++) { // 判断之前行是否存在冲突皇后
                if (col == position[i] || col + row == position[i] + i || row - col == i - position[i]) {
                    ok = false;
                    break;
                }
            }
            if (!ok)
                continue;
            position[row] = col;
            dfs(row + 1, n, position, result);
            position[row] = -1;
        }
    }

}
