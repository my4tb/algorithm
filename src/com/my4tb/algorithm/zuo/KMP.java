package com.my4tb.algorithm.zuo;

public class KMP {

    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(kmp.isSub("mississippi", "issip"));
    }

    public boolean isSub(String s, String p) {
        if (p.length() == 0)
            return true;
        if (s.length() < p.length())
            return false;
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        int[] next = getNext(pChars);
        int i = 0, j = 0;
        while (i < sChars.length && j < pChars.length) {
            if (sChars[i] == pChars[j]) {
                i++;
                j++;
            }
            else if (next[j] != -1)
                j = next[j];
            else
                i++;
        }
        return j == pChars.length;
    }

    private int[] getNext(char[] chars) {
        if (chars.length == 1)
            return new int[] {-1};
        int[] next = new int[chars.length];
        next[0] = -1;
        next[1] = 0;
        int idx = 2, cn = 0;
        while (idx < chars.length) {
            if (chars[idx - 1] == chars[cn])
                next[idx++] = ++cn;
            else if (next[cn] != -1)
                cn = next[cn];
            else
                next[idx++] = 0;
        }
        return next;
    }

}
