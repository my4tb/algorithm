package com.my4tb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _131 {

    static boolean[][] state;
    static List<List<String>> rst;

    public static List<List<String>> partition(String s) {
        rst = new ArrayList<>();

        if (s == null || s.length() == 0)
            return rst;

        state = palindromeState(s);

        dfs(s, 0, new ArrayList<>());

        return rst;
    }

    private static void dfs(String str, int curr, List<String> localRst) {
        if (curr == str.length()) {
            rst.add(new ArrayList<>(localRst));
            return;
        }
        for (int i = curr; i < str.length(); i++) {
            if (state[curr][i]) {
                localRst.add(str.substring(curr, i + 1));
                dfs(str, i + 1, localRst);
                localRst.remove(localRst.size() - 1);
            }
        }
    }

    private static boolean[][] palindromeState(String str) {
        int len = str.length();
        boolean[][] state = new boolean[len][len];

        int l = 0, r = 0;
        while (r < len) {
            for (int i = l, j = r; i >= 0 && j < len; i--, j++) {
                if (i == j)
                    state[i][j] = true;
                else if (str.charAt(i) == str.charAt(j))
                    state[i][j] = true;
                else
                    break;
            }

            if (l == r)
                r++;
            else
                l++;
        }

        return state;
    }

    public static void main(String[] args) {
        System.out.println(partition("abaa"));
    }

}
