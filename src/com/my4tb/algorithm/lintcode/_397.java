package com.my4tb.algorithm.lintcode;

public class _397 {

    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public static int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if (A == null || A.length == 0)
            return 0;

        int[] status = new int[A.length];
        status[0] = 1;
        int max = 1;

        for (int i = 1; i < A.length; i++) {
            status[i] = A[i] > A[i - 1] ? 1 + status[i - 1] : 1;
            max = Math.max(status[i], max);
        }

        reverse(A);

        status[0] = 1;
        for (int i = 1; i < A.length; i++) {
            status[i] = A[i] > A[i - 1] ? 1 + status[i - 1] : 1;
            max = Math.max(status[i], max);
        }

        return max;
    }

    private static void reverse(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            swap(i++, j--, A);
        }
    }

    private static void swap(int i, int j, int[] A) {
        if (i == j)
            return;
        A[i] = A[i] ^ A[j];
        A[j] = A[i] ^ A[j];
        A[i] = A[i] ^ A[j];
    }

    public static void main(String[] args) {
        int[] A = {5, 1, 2, 3, 4};
//        reverse(A);
        System.out.println(longestIncreasingContinuousSubsequence(A));
    }

}
