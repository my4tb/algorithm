package com.my4tb.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * adjacency list node
 */
public class GraphNode_AL {

    public int val;

    public boolean visited;

    private List<GraphNode_AL> neighbors; // 当前节点的邻居节点

    public GraphNode_AL(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    /**
     * @param idx 邻居编号
     * @return 编号对应邻居
     */
    public GraphNode_AL getNeighbor(int idx) {
        return neighbors.get(idx);
    }

    public void addNeighbor(GraphNode_AL node) {
        neighbors.add(node);
    }

    /**
     * @return 获取当前节点邻居数
     */
    public int size() {
        return neighbors.size();
    }

}
