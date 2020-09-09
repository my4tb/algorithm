package com.my4tb.algorithm.slidingwindow;

/**
 * leetcode 209
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(3, new int[]{1, 1}));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int sum = 0, len = 0, l = 0, r = 0;
        while (r < nums.length) {
            sum += nums[r++];
            if (sum >= s) {
                while (l < r && sum - nums[l] >= s) {
                    sum -= nums[l++];
                }
                len = len == 0 ? r - l : Math.min(len, r - l);
                System.out.println("r : " + r + ", l : " + l);
                sum -= nums[l++];
                System.out.println("sum = " + sum);
            }
        }
        return len;
    }

}
