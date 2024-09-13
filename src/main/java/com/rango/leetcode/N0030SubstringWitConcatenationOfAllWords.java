package com.rango.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/substring-with-concatenation-of-all-words">30.串联所有单词的子串</a>
 */
public class N0030SubstringWitConcatenationOfAllWords {

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s, words));

        s = "barbarbarbar";
        words = new String[]{"bar", "bar"};
        System.out.println(findSubstring(s, words));

        s = "wordgoodgoodgoodbestword";
        words = new String[]{"word", "good", "best", "word"};
        System.out.println(findSubstring(s, words));

        s = "barfoofoobarthefoobarman";
        words = new String[]{"bar", "foo", "the"};
        System.out.println(findSubstring(s, words));

    }

    public static List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> targetMap = new HashMap<>();
        for (String word : words) {
            targetMap.put(word, targetMap.getOrDefault(word, 0) + 1);
        }

        List<Integer> answerList = new ArrayList<>();
        int singleWordLength = words[0].length();
        int totalWordLength = singleWordLength * words.length;
        for (int i = 0; i < singleWordLength; i++) {
            // 注意窗口相关状态在 for 循环内侧定义，即对每个起点初始化单独的窗口
            int start = i, matchWordCount = 0;
            Map<String, Integer> windowMap = new HashMap<>();
            for (int j = start; j + singleWordLength - 1 <= s.length() - 1; j += singleWordLength) {
                String word = s.substring(j, j + singleWordLength);

                if (targetMap.containsKey(word)) {
                    // 当前单词可以加入窗口
                    int times = windowMap.getOrDefault(word, 0) + 1;
                    windowMap.put(word, times);
                    if (times == targetMap.get(word)) {
                        matchWordCount++;
                    }

                    while (matchWordCount == targetMap.size()) {
                        // 注意添加逻辑一定要写在 while 里面
                        if (j + singleWordLength == start + totalWordLength) {
                            answerList.add(start);
                        }

                        String leftmostWord = s.substring(start, start + singleWordLength);
                        int leftmostWordTimes = windowMap.get(leftmostWord);
                        if (leftmostWordTimes == targetMap.getOrDefault(leftmostWord, Integer.MAX_VALUE)) {
                            matchWordCount--;
                        }
                        windowMap.put(leftmostWord, leftmostWordTimes - 1);
                        start += singleWordLength;
                    }
                } else {
                    // 当前单词无法加入窗口，清空窗口相关状态
                    windowMap.clear();
                    start = j + singleWordLength;
                    matchWordCount = 0;
                }
            }
        }

        return answerList;
    }

}
