package com.my4tb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _118 {

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rst = new ArrayList<>();

        addRow(numRows, 1, rst, null);

        return rst;
    }

    private static void addRow(int totalRow, int currRow, List<List<Integer>> rst, List<Integer> preRow) {
        if (currRow == 1) {
            rst.add(Arrays.asList(1));
        } else if (currRow == 2) {
            rst.add(Arrays.asList(1, 1));
        } else {
            List<Integer> currRowRst = new ArrayList<>();
            currRowRst.add(1);
            for (int i = 1; i < currRow - 1; i++) {
                currRowRst.add(preRow.get(i - 1) + preRow.get(i));
            }
            currRowRst.add(1);
            rst.add(currRowRst);
        }
        if (totalRow != currRow)
            addRow(totalRow, currRow + 1, rst, rst.get(rst.size() - 1));
    }

    public static void main(String[] args) {
        System.out.println(generate(1));
        System.out.println(generate(2));
        System.out.println(generate(3));
        System.out.println(generate(4));
        System.out.println(generate(5));
    }

}
