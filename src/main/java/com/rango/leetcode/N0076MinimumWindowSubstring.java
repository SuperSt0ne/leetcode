package com.rango.leetcode;

/**
 * <a href="https://leetcode.cn/problems/minimum-window-substring/">76. 最小覆盖子串</a>
 * --> s = "ADOBECODEBANC", t = "ABC"
 * ==> "BANC"
 */
public class N0076MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        int MAX = 100001;
        int start = 0, end = MAX;
        //大写字符ASCII 65-90；小写字符ASCII 97-122
        int[] targetMap = new int[128]; //注意可能存在大小写字符，所以申请容量128
        int targetChars = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (targetMap[c]++ == 0) {
                targetChars++;
            }
        }

        int matchChars = 0;
        //window[i, j]
        int[] windowMap = new int[128];
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (++windowMap[c] == targetMap[c]) {
                matchChars++;
            }
            while (matchChars >= targetChars) {
                if (j - i < end - start) {
                    start = i;
                    end = j;
                }
                char left = s.charAt(i);
                if (windowMap[left]-- == targetMap[left]) {
                    matchChars--;
                }
                i++;
            }
        }
        return end == MAX ? "" : s.substring(start, end + 1);
    }

}
