package com.rango.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/word-pattern/">290. 单词规律</a>
 */
public class N0290WordPattern {

    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));

        pattern = "abc";
        s = "dog cat dog";
        System.out.println(wordPattern(pattern, s));
    }

    /**
     * 双射
     */
    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> fromToMap = new HashMap<>();
        Map<String, Character> toFromMap = new HashMap<>();
        String[] wordArr = s.split(" ");
        if (pattern.length() != wordArr.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char from = pattern.charAt(i);
            String to = wordArr[i];

            String exceptedTo = fromToMap.get(from);
            if (exceptedTo != null && !exceptedTo.equals(to)) {
                return false;
            }
            Character exceptedFrom = toFromMap.get(to);
            if (exceptedFrom != null && exceptedFrom != from) {
                return false;
            }
            fromToMap.put(from, to);
            toFromMap.put(to, from);
        }
        return true;
    }

}
