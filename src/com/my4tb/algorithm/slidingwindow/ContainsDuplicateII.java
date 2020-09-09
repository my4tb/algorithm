package com.my4tb.algorithm.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 219
 */
public class ContainsDuplicateII {

    public static void main(String[] args) {
        ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();
        System.out.println(containsDuplicateII.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

    /*
        这里的k就相当于滑动窗口的区间
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2)
            return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k)
                set.remove(nums[i - k]);
        }
        return false;
    }

}
