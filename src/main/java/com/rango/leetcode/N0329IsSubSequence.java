package com.rango.leetcode;

/**
 * <a href="https://leetcode.cn/problems/is-subsequence/">329.判断子序列</a>
 */
public class N0329IsSubSequence {

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));

        s = "axc";
        t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int slow = 0, fast = 0;
        while (fast < t.length() && slow < s.length()) {
            if (t.charAt(fast) == s.charAt(slow)) {
                if (slow == s.length() - 1) {
                    return true;
                }
                slow++;
            }
            fast++;
        }
        return false;
    }

}
