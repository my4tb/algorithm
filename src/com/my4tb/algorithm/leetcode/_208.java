package com.my4tb.algorithm.leetcode;

public class _208 {

    public static class Trie {

        private final Trie[] children;
        private boolean isEnd;

        Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie root = this;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int idx = c - 'a';
                if (root.children[idx] == null)
                    root.children[idx] = new Trie();
                root = root.children[idx];
            }
            root.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startWith(String prefix) {
            Trie node = searchPrefix(prefix);
            return node != null;
        }

        public Trie searchPrefix(String prefix) {
            Trie root = this;
            char[] chars = prefix.toCharArray();
            for (char c : chars) {
                int idx = c - 'a';
                if (root.children[idx] == null)
                    return null;
                root = root.children[idx];
            }
            return root;
        }

    }

    public static void main(String[] args) {

    }

}
