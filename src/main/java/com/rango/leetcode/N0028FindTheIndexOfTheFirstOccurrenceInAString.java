package com.rango.leetcode;

/**
 * <a href="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string">找出字符串中第一个匹配项的下标</a>
 */
public class N0028FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("xsdleetocode", "leeto"));
    }

    // TODO: 2024/9/10 KMP算法

    /**
     * 比较指针回溯
     */
    public static int strStr(String haystack, String needle) {
        int ans = 0, n = haystack.length();
        char[] hc = haystack.toCharArray(), nc = needle.toCharArray();
        while (ans <= n - nc.length) {
            for (int j = 0; j < nc.length; j++) {
                if (hc[j + ans] != nc[j]) {
                    break;
                }
                if (j == nc.length - 1) {
                    return ans;
                }
            }
            ans++;
        }
        return -1;
    }

}
