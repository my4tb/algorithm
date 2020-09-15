package com.my4tb.algorithm.zuo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionFind {

    private static class Node {}

    private static class UnionFindSet {

        private Map<Node, Node> fatherNodes; // key - curr, value - parent
        private Map<Node, Integer> currSize; // current set's size

        public UnionFindSet(List<Node> nodes) {
            makeSets(nodes);
        }

        private void makeSets(List<Node> nodes) {
            this.fatherNodes = new HashMap<>();
            this.currSize = new HashMap<>();
            nodes.forEach(node -> {
                fatherNodes.put(node, node);
                currSize.put(node, 1);
            });
        }

        private Node findHead(Node node) {
            Node father = fatherNodes.get(node);
            while (node != father)
                father = findHead(father);
            fatherNodes.put(node, father); // 在查找最顶节点时，将路径上的每个节点都直接挂到最顶节点上
            return father;
        }

        public boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null)
                return;
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if (aHead != bHead) {
                int aSize = currSize.get(a);
                int bSize = currSize.get(b);
                if (aSize >= bSize) { // 将个数少的集合挂到个数多的集合
                    fatherNodes.put(bHead, aHead);
                    currSize.put(a, aSize + bSize);
                }
                else {
                    fatherNodes.put(aHead, bHead);
                    currSize.put(b, aSize + bSize);
                }
            }
        }

    }

}
