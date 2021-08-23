package com.my4tb.algorithm.lintcode;

public class _1 {

    /**
     * a ^ b 是不进位加法，如：
     *  3 -  11
     *  5 - 101
     * 3 ^ 5 =  110
     * 3 + 5 = 1000
     * 本该在最低位有进位，最终得到二进制表示 1000，而异或操作没有进位
     *
     * 如何计算进位？
     * (a & b) << 1 即是相加操作应该有的进位
     *
     * 可以得到：
     * a + b = (a ^ b) + ((a & b) << 1)
     *
     * 上面表达式又存在加号，重复进行上述过程即可，直到没有进位产生，即(a & b) << 1 = 0
     */
    public static int aPlusB(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = temp ^ b;
            b = (temp & b) << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(aPlusB(3, 5));
    }

}
