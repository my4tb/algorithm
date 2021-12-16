package com.my4tb.algorithm.leetcode;

public class _746 {

    /**
     * 考虑最后一步，最优策略下，假设最后一步的最小代价是n
     * 那么前面n-1或n-2一定是最小的
     * <p>
     * f[i]表示到达i的最小代价
     */
    private static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len == 2)
            return Math.min(cost[0], cost[1]);
        if (len == 1)
            return cost[0];
        if (len == 0)
            return 0;
        int pp = 0, p = 0;
        int curr = 0;

        for (int i = 2; i <= len; i++) {
            curr = Math.min(pp + cost[i - 2], p + cost[i - 1]);
            pp = p;
            p = curr;
        }

        return curr;
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[] {10, 15, 20}));
        System.out.println(minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

}
