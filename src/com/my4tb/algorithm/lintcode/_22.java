package com.my4tb.algorithm.lintcode;

import java.util.ArrayList;
import java.util.List;

public class _22 {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> list = new ArrayList();
        if (nestedList == null || nestedList.size() == 0)
            return list;
        for (NestedInteger integer : nestedList) {
            if (integer.isInteger())
                list.add(integer.getInteger());
            else {
                List<Integer> integerList = flatten(integer.getList());
                list.addAll(integerList);
            }
        }
        return list;
    }

    public static void main(String[] args) {
    }


    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     */
    interface NestedInteger {

        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

}
