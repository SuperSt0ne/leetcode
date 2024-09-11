package com.rango.leetcode;

/**
 * <a href="https://leetcode.cn/problems/length-of-last-word">最后一个单词的长度</a>
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大
 * 子字符串
 * 。
 */
public class N0058LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a"));
    }

    public static int lengthOfLastWord(String s) {
        int ans = 0;
        boolean start = false;
        for (int i = s.length() - 1; i > 0; i--) {
            char c = s.charAt(i);
            if (' ' == c) {
                if (start) {
                    break;
                }
            } else {
                ans++;
                if (!start) {
                    start = true;
                }
            }
        }
        return ans;
    }

}
