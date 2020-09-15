package com.my4tb.algorithm.primenum;

import java.util.ArrayList;
import java.util.List;

/**
 * 分解质因数
 */
public class AllPrimeNum {
    public static void main(String[] args) {
        System.out.println(new AllPrimeNum().getAllPrimeNums(6));
    }
    // n >= 2
    private List<Integer> getAllPrimeNums(int n) {
        int k = 2;
        List<Integer> result = new ArrayList<>();
        while (n > k) {
            if (n % k == 0) {
                result.add(k);
                n /= k;
            }
            else
                k++;
        }
        result.add(k);
        return result;
    }

}
