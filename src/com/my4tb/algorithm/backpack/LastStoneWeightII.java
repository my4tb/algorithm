package com.my4tb.algorithm.backpack;

import java.util.Arrays;

/**
 * leetcode 1049
 */
public class LastStoneWeightII {
    public static void main(String[] args) {
        LastStoneWeightII lastStoneWeightII = new LastStoneWeightII();
        System.out.println(lastStoneWeightII.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }
    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0)
            return 0;
        int sum = 0;
        for (int stone : stones)
            sum += stone;
        int V = (sum + 1) / 2;
        System.out.println("V = " + V);
        int[] f = new int[V + 1];
        for (int stone : stones)
            for (int i = V; i >= stone; i--)
                f[i] = Math.max(f[i], f[i - stone] + stone);

//        System.out.println(Arrays.toString(f));
        return Math.abs(f[V] - (sum - f[V]));
    }

}
