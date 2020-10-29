package com.my4tb.algorithm.lanqiao;

/**
 * 快速幂运算
 */
public class FastPowerOperation {

    public static void main(String[] args) {
        System.out.println(nExponent(2, 10));
    }

    /**
     * 求a的n次幂的值
     */
    private static long nExponent(int a, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return a;
        long result = a;
        int exponent = 1;
        while ((exponent << 1) <= n) {
            result *= result;
            exponent <<= 1;
        }
        return result * nExponent(a, n - exponent);
    }

}
