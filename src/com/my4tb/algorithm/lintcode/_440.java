package com.my4tb.algorithm.lintcode;

public class _440 {

    private static int backPackIII(int m, int[] A, int[] V) {
        // write your code here
        if (m == 0)
            return 0;

        int[] f = new int[m + 1];

        for (int i = 1; i <= m; i++) { // backpack capacity
            int max = 0;
            for (int j = 0; j < A.length; j++)  // infinity material
                if (i >= A[j])
                    max = Math.max(max, f[i - A[j]] + V[j]);
            f[i] = max;
        }

        return f[m];
    }

    public static void main(String[] args) {
        System.out.println(backPackIII(10, new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}));
        System.out.println(backPackIII(5, new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }

}
