package com.rango.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/zigzag-conversion/">3.无重复字符的最长子串</a>
 */
public class N0003LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));

        s = "abba";
        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 1) {
            return n;
        }
        int ans = 0;
        // window[i, j]
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            Integer prevIndex = map.get(s.charAt(j));
            if (prevIndex != null) {
                // 出现了重复字符，重置窗口起点
                // ['a', 'b', 'c', 'a', 'b', 'c'], 当遇到第二个 'a' 时，i 移动至第一个 'a' 的下一个位置
                // 注意此处一定要使用 Math.max, 避免指针 i 回退
                // ['a', 'b', 'b', 'a'], 避免遍历至第二个 'a' 时 i 从 'b' 回退至第一个 'a' 的下一个位置
                i = Math.max(i, prevIndex + 1);
            }
            map.put(s.charAt(j), j);
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
