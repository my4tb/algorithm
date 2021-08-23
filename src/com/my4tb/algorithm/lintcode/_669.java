package com.my4tb.algorithm.lintcode;

public class _669 {

    /**
     * @param coins:  a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public static int coinChange(int[] coins, int amount) {
        // write your code here
        if (coins == null || coins.length == 0 || amount < 0)
            return -1;
        int[] status = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            status[i] = -1;
            for (int coin : coins) {
                if (i >= coin && status[i - coin] != -1) {
                    if (status[i] == -1)
                        status[i] = 1 + status[i - coin];
                    else
                        status[i] = Math.min(status[i], 1 + status[i - coin]);
                }
            }
        }
        return status[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{5}, 11));
    }

}
