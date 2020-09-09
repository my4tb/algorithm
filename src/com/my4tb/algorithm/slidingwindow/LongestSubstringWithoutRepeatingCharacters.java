package com.my4tb.algorithm.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 3
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring(""));
    }

    /*
        要想清楚窗口的区间，下面的解法是将滑动窗口的区间设定为[l, r]，窗口的长度为r - l + 1;
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int l = 0, r = -1, max = r - l + 1;
        while (l < chars.length) {
            if (r + 1 < chars.length && !set.contains(chars[r + 1])) {
                set.add(chars[++r]);
            }
            else if (r + 1 == chars.length)
                break;
            else
                set.remove(chars[l++]);
            max = Math.max(max, r - l + 1);
        }
        return max;
    }

}
