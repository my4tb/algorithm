package com.my4tb.algorithm.lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 假设最后一步跳的长度为L，跳到了最后一块石头，那么前一块石头
 * 的位置是:stones[n-1] - L
 * <p>
 * f[i][j]表示跳了j的距离后能否到达第i块石头，状态依赖于位置在
 * stones[i-1]-j的石头是否可以到达，而跳到stones[i-1]-j位置
 * 上的石头，是可以在更前一块石头上跳j、j-1或j+1的距离的
 * <p>
 * 本题中需要快速知道某个位置上是否有石头
 * 可以通过hashmap存储位置从而达到O(1)
 * <p>
 * 第一次跳跃距离为1，最多跳n-1次，所以最大跳跃距离为n-1
 */
public class _622 {

    private static boolean canCross(int[] stones) {
        // write your code here
        Map<Integer, Integer> position = new HashMap<>() {
            {
                for (int i = 0; i < stones.length; i++)
                    put(stones[i], i);
            }
        };
        boolean[][] f = new boolean[stones.length][stones.length];
        for (int i = 0; i < stones.length; i++) { // from first to last, 0 ... n-1
            for (int j = 0; j < stones.length; j++) { // from 1 to n - 1 distance
                if (i == 0 && j == 0) // to first stone by jump distance 0
                    f[i][j] = true;
                else if (i == 0 || j == 0) // to first stone by jump any other distance, and, to no first stone by jump only 0 distance
                    f[i][j] = false;
                else {
                    int prePos = stones[i] - j;
                    Integer preStoneIdx = position.get(prePos);
                    if (preStoneIdx != null) {
                        f[i][j] = f[preStoneIdx][j - 1] || f[preStoneIdx][j];
                        if (j + 1 < stones.length)
                            f[i][j] = f[i][j] || f[preStoneIdx][j + 1];
                    }
                }
            }
        }
        for (boolean b : f[stones.length - 1])
            if (b)
                return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        System.out.println(canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }

}
