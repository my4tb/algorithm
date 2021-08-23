package com.my4tb.algorithm.lintcode;

public class _664 {

    /**
     * @param num: a non negative integer number
     * @return: an array represent the number of 1's in their binary
     */
    public static int[] countBits(int num) {
        // write your code here
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++)
            f[i] = f[i >> 1] + i % 2;
        return f;
    }

    // 计算二进制表示有多少位
    private static int countNum(int num) {
        if (num == 0)
            return 0;
        int count = 1;
        int n = 1;
        while (n < num) {
            n <<= 1;
            if (n <= num)
                count++;
            else
                break;
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(countBits(3)));
        System.out.println(countNum(8));
    }

}
