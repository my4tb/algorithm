package com.my4tb.algorithm.lintcode;

import java.util.LinkedList;
import java.util.List;

public class _623 {

    private static class Trie {
        private final Trie[] children;
        private boolean isWord;
        private String word;

        Trie() {
            this.children = new Trie[26];
            isWord = false;
            word = "";
        }

        private void insert(String word) {
            char[] chars = word.toCharArray();
            Trie root = this;
            for (char c : chars) {
                int idx = c - 'a';
                if (root.children[idx] == null)
                    root.children[idx] = new Trie();
                root = root.children[idx];
            }
            root.isWord = true;
            root.word = word;
        }

    }

    private List<String> rst;
    private int len;
    private int k;
    private String target;

    private List<String> kDistance(String[] words, String target, int k) {
        // write your code here
        // get a trie
        Trie root = new Trie();
        for (String word : words)
            root.insert(word);

        rst = new LinkedList<>();
        len = target.length();
        this.k = k;
        this.target = target;

        // f["xx"][i]表示"xx"变为target的第i个字符的操作次数
        // f["xx"][i]的计算会依赖f["x"][i-1, i]的数据
        // 初始化时，f表示""到target的前i个字符需要的操作次数
        int[] f = new int[len + 1];
        for (int i = 1; i <= len; i++)
            f[i] = i;

        dfs(root, f);

        return rst;
    }

    /**
     * @param p 前缀树前层节点
     * @param f 前缀树前一个节点表示的字符串到target的最少操作次数，
     *          用于计算当前节点表示字符串到target的最小操作次数
     */
    private void dfs(Trie p, int[] f) {
        // 前层节点表示的词
        if (p.isWord) { // 前层节点是否是一个词
            if (f[len] <= k) // 前层节点表示的词到target的前k个字符，即整个target，所需要的操作次数是否<=k
                rst.add(p.word);
        }
        // 当前层
        int[] nf = new int[len + 1];
        nf[0] = f[0] + 1;
        for (int i = 0; i < 26; i++) {
            if (p.children[i] == null)
                continue;
            for (int j = 1; j <= len; j++) { // 看当前节点表示的词到target的所有字符需要操作的最少次数
                char c = target.charAt(j - 1);
                if (c - 'a' == i)
                    nf[j] = f[j - 1];
                else {
                    int a_ = nf[j - 1]; // 源字符串加一个字符与target第j个字符匹配
                    int b_ = f[j - 1]; // 源字符串改变最后一个字符与target第j个字符匹配
                    int c_ = f[j];// 源字符串删掉最后一个字符，也就上一层的源字符串与target第j个字符匹配
                    nf[j] = min(a_, b_, c_) + 1;
                }
            }
            dfs(p.children[i], nf);
        }
    }

    private static int min(int... nums) {
        int rst = Integer.MAX_VALUE;
        for (int num : nums)
            if (num < rst)
                rst = num;
        return rst;
    }

    public static void main(String[] args) {
        _623 obj = new _623();
        System.out.println(obj.kDistance(new String[]{"abc", "abd", "abcd", "adc"}, "ac", 1));
        System.out.println(obj.kDistance(new String[]{"acc", "abcd", "ade", "abbcd"}, "abc", 2));
    }

}













