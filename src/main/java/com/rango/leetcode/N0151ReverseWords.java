package com.rango.leetcode;

/**
 * <a href="https://leetcode.cn/problems/reverse-words-in-a-string">反转字符串中的单词</a>
 */
public class N0151ReverseWords {

    public static void main(String[] args) {
        String a = " hello world  ";
        System.out.println(reverseWords(a));
        String b = "the sky is blue";
        System.out.println(reverseWords(b));
        String c = "a good   example";
        System.out.println(reverseWords(c));
    }

    public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            while (i >= 0 && s.charAt(i) == ' ') {
                --i;
            }
            int end = i;
            if (i < 0) {
                break;
            }
            while (i >= 0 && s.charAt(i) != ' ') {
                --i;
            }
            ans.append(" ").append(s, i + 1, end + 1);
        }
        return ans.substring(1);
    }
}
