package com.my4tb.algorithm.lintcode;

import java.util.HashSet;
import java.util.Set;

public class _679 {

    /*
     * @param : an array of arrays
     * @return: the sum of all unique weighted paths
     */
    public static int uniqueWeightedPaths(int[][] grid) {
        // write your codes here
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        Set<Integer>[][] s = new HashSet[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0)
                    set(s, i, j, grid[i][j]);
                else {
                    if (i > 0)
                        for (Integer v : s[i - 1][j])
                            set(s, i, j, grid[i][j] + v);
                    if (j > 0)
                        for (Integer v : s[i][j - 1])
                            set(s, i, j, grid[i][j] + v);
                }
            }
        int rst = 0;
        for (int v : s[grid.length - 1][grid[0].length - 1])
            rst += v;
        return rst;
    }

    private static void set(Set<Integer>[][] s, int i, int j, int val) {
        if (s[i][j] == null)
            s[i][j] = new HashSet<>();
        s[i][j].add(val);
    }

    public static void main(String[] args) {
        System.out.println(uniqueWeightedPaths(new int[][]{
                {1, 1, 2},
                {1, 2, 3},
                {3, 2, 4}
        }));
    }

}
