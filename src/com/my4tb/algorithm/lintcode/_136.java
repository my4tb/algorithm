package com.my4tb.algorithm.lintcode;

import java.util.ArrayList;
import java.util.List;

public class _136 {

    private static List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> rst = new ArrayList<>();
        if (s == null || s.length() == 0)
            return rst;
        boolean[][] f = palindrome(s);
        dfs(0, f, s, new ArrayList<>(), rst);
        return rst;
    }

    private static void dfs(int idx, boolean[][] f, String s, List<String> curr, List<List<String>> rst) {
        if (idx == f.length) {
            rst.add(new ArrayList<>(curr));
            return;
        }
        for (int i = idx; i < f.length; i++) {
            if (f[idx][i]) {
                curr.add(s.substring(idx, i + 1));
                dfs(i + 1, f, s, curr, rst);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private static boolean[][] palindrome(String s) {
        char[] chars = s.toCharArray();
        boolean[][] f = new boolean[chars.length][chars.length];
        int l = 0, r = 0;
        while (r < chars.length) {
            int i = l, j = r;
            while (i >= 0 && j < chars.length) {
                if (chars[i] == chars[j]) {
                    f[i--][j++] = true;
                } else {
                    break;
                }
            }
            if (l == r)
                r++;
            else
                l++;
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(partition("abbccbb"));
    }

}
