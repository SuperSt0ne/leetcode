package com.rango.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/group-anagrams/">49. 字母异位词分组</a>
 */
public class N0049GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams_cnt(strs));
        System.out.println(groupAnagrams_sort(strs));
    }

    /**
     * 排序
     */
    public static List<List<String>> groupAnagrams_sort(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 计数
     */
    public static List<List<String>> groupAnagrams_cnt(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] cnt = new int[26];
            for (int i = 0; i < str.length(); i++) {
                cnt[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (cnt[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(cnt[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

}
