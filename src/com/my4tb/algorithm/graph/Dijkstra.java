package com.my4tb.algorithm.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 单源最短路径问题
 */
public class Dijkstra {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int countNodes = scan.nextInt(); // 节点数
        int countEdge = scan.nextInt(); // 边数
        int source = scan.nextInt(); // 单源编号

        int[][] values = new int[countNodes + 1][countNodes + 1]; // values[i][j]表示节点i到节点j的直接路径长度，若为正无穷，表示没有直接路径
        int[] distances = new int[countNodes + 1]; // distances[i]表示单源节点x到节点i的最短距离

        for (int i = 1; i <= countNodes; i++) {
            distances[i] = i == source ? 0 : Integer.MAX_VALUE;
            Arrays.fill(values[i], Integer.MAX_VALUE);
            values[i][i] = 0;
        }

        for (int i = 0; i < countEdge; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int distance = scan.nextInt();
            values[from][to] = distance;
            if (from == source)
                distances[to] = distance;
        }

        boolean[] mark = new boolean[countNodes + 1];
        mark[source] = true;
        int count = 1; // 表示已经处理完毕count个节点，当count达到countNodes时，所有节点都处理完毕

        while (count < countNodes) {
            // 在所有未加入的节点中，找到距离单源节点最近的节点，并将其加入已处理的集合内
            int minDistance = Integer.MAX_VALUE;
            int minNode = 0;
            for (int i = 1; i <= countNodes; i++) {
                if (!mark[i] && distances[i] < minDistance) {
                    minNode = i;
                    minDistance = distances[i];
                }
            }
            // 表示所有节点都不满足继续添加的条件了
            if (minNode == 0)
                break;
            // 标记当前处理节点
            mark[minNode] = true;
            count++;
            // 由于添加了新的节点，尝试着更新单源节点到其它各节点的路径长度
            // 已经添加了的节点，到单源节点已经是最短的路径了，因此不必更新
            for (int i = 1; i <= countNodes; i++) {
                // 如果遍历到的节点尚未更新，并且当前加入的节点到遍历到的节点存在路径，
                // 并且单源节点到当前加入的节点的距离，加上当前加入的节点到遍历到的节点
                // 的距离比单源节点到当前遍历到的节点的路径长度更小，则更新
                if (!mark[i] && values[minNode][i] != Integer.MAX_VALUE && distances[minNode] + values[minNode][i] < distances[i])
                    distances[i] = distances[minNode] + values[minNode][i];
            }
        }

        System.out.println("单源节点为：" + source);

        System.out.println("单源节点到各节点之间的距离为：");

        for (int i = 1; i <= countNodes; i++)
            if (i != source)
                System.out.println("到达节点 " + i + " 的距离为：" + distances[i]);

    }

}
