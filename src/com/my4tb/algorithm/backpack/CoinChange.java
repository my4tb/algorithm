package com.my4tb.algorithm.backpack;

import java.util.Arrays;

/**
 * leetcode 322
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange1(new int[]{1, 2, 5}, 6));
        System.out.println("---------------------");
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 6));
    }

    public int coinChange1(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][0] = 0;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                for (int k = 0; k * coins[i - 1] <= j; k++) {
                    if (dp[i - 1][j - k * coins[i - 1]] == -1)
                        continue;
                    if (dp[i][j] == -1)
                        dp[i][j] = dp[i - 1][j - k * coins[i - 1]] + k;
                    else
                        dp[i][j] = Math.min(dp[i - 1][j - k * coins[i - 1]] + k, dp[i][j]);
                }
            }
        }
        for (int[] ints : dp)
            System.out.println(Arrays.toString(ints));
        return dp[coins.length][amount];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        System.out.println(Arrays.toString(dp));
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] == -1)
                    continue;
                if (dp[i] == -1)
                    dp[i] = dp[i - coin] + 1;
                else
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];
    }

}
