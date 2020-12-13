package com.dzx.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 滑动窗口
 */

public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int length = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                length = right-left+1;
                max = Math.max(max, length);
            }else {
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
//                set.remove(s.charAt(left));
                left++;
            }
            right++;
        }
        return max;
    }
}
