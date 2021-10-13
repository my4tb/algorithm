package com.my4tb.algorithm.lintcode;

public class _76 {

    /**
     * 设 f[i] 为以下标 i 为结尾的最长子序列长度，
     * f[i] 的值为，找到 [0, i - 1] 区间内最后一个比 nums[i] 小的值，假设为下标为 j 的值，
     * f[i] = f[j] + 1
     * 如果没有比 nums[i] 小的值，则 f[i] = 1
     * 这种时间复杂度为 O(n^2)
     */
    public static int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0)
            return 0;
        int max = 1;
        int[] f = new int[nums.length];
        f[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    f[i] = Math.max(f[j] + 1, f[i]);
                }
            }
            if (f[i] == 0)
                f[i] = 1;
            max = Math.max(max, f[i]);
        }
        return max;
    }

    /**
     * 采用辅助数组的方法
     */
    private static int longestIncreasingSubsequenceOptimized(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int top = 0;
        for (int i = 1; i < nums.length; i++) {
            // 找到第一个比当前数大的数，替换掉
            // 这里继续优化，使用二分查找
            int curr = nums[i];
            if (f[top] > curr) {
                for (int j = 0; j <= top; j++) {
                    if (f[j] > curr) {
                        f[j] = curr;
                        break;
                    }
                }
            } else if (f[top] < curr) {
                f[++top] = curr;
            }
        }
        return top + 1;
    }

    private static int longestIncreasingSubsequenceOptimizedByBinary(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int top = 0;
        for (int i = 1; i < nums.length; i++) {
            // 找到第一个比当前数大的数，替换掉
            int curr = nums[i];
            if (f[top] > curr) {
                // binary
                int l = 0, r = top, mid;
                while (l <= r) {
                    mid = l + (r - l) / 2;
                    if (f[mid] <= curr)
                        l = mid + 1;
                    else
                        r = mid - 1;
                }
                f[l] = curr;
            } else if (f[top] < curr) {
                f[++top] = curr;
            }
        }
        return top + 1;
    }

    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequence(new int[]{5, 4, 1, 2, 3}));
        System.out.println(longestIncreasingSubsequenceOptimizedByBinary(new int[]{88, 4, 24, 82, 86, 1, 56, 74, 71, 9, 8, 18, 26, 53, 77, 87, 60, 27, 69, 17, 76, 23, 67, 14, 98, 13, 10, 83, 20, 43, 39, 29, 92, 31, 0, 30, 90, 70, 37, 59}));
    }

}


















