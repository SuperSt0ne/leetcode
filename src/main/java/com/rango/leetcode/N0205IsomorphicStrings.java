package com.rango.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/ransom-note/">205. 同构字符串</a>
 */
public class N0205IsomorphicStrings {

    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(isIsomorphic(s, t));
    }

    /**
     * 双射
     */
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> fromToMap = new HashMap<>();
        Map<Character, Character> toFromMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char from = s.charAt(i), to = t.charAt(i);
            Character exceptedTo = fromToMap.get(from);
            if (exceptedTo != null && exceptedTo != to) {
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
