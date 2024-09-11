package com.rango.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/text-justification/description/">文本左右对齐</a>
 */
public class N0068TextJustification {

    public static void main(String[] args) {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        print(fullJustify(words, maxWidth));

        words = new String[] {"What","must","be","acknowledgment","shall","be"};
        maxWidth = 16;
        print(fullJustify(words, maxWidth));

        words = new String[] {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        maxWidth = 20;
        print(fullJustify(words, maxWidth));
    }

    private static void print(List<String> ansList) {
        StringBuilder builder = new StringBuilder();
        for (String ans : ansList) {
            builder.append(",").append("\"").append(ans).append("\"");
        }
        System.out.println(builder.substring(1));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lineList = new ArrayList<>();
        List<String> cacheList = new ArrayList<>();
        int width = 0;
        for (String word : words) {
            if (cacheList.isEmpty()) {
                cacheList.add(word);
                width += word.length();
            } else {
                if (width + 1 + word.length() <= maxWidth) {
                    cacheList.add(' ' + word);
                    width += 1 + word.length();
                } else {
                    int extraSpace = maxWidth - width;
                    StringBuilder lineBuilder = new StringBuilder(maxWidth);
                    if (cacheList.size() == 1) {
                        // 该行只有一个单词，多余空格全部添加至行尾
                        lineBuilder.append(cacheList.get(0));
                        appendSpaceToBuilder(lineBuilder, extraSpace);
                    } else {
                        // 当前行存在多个单词，需要平分多余空格，对于不能平分的部分，累加至最左侧
                        int intervalCount = cacheList.size() - 1; //区间数
                        int intervalSpace = extraSpace / intervalCount; //区间空格数
                        int leftIntervalSpace = extraSpace % intervalCount; // 区间多余空格数
                        lineBuilder.append(cacheList.get(0));
                        for (int i = 1; i < cacheList.size(); i++) {
                            appendSpaceToBuilder(lineBuilder, intervalSpace);
                            appendSpaceToBuilder(lineBuilder, leftIntervalSpace-- > 0 ? 1 : 0);
                            lineBuilder.append(cacheList.get(i));
                        }
                    }
                    lineList.add(lineBuilder.toString());

                    width = 0;
                    cacheList.clear();
                    cacheList.add(word);
                    width += word.length();
                }
            }
        }
        // 最后一行
        StringBuilder lastLineBuilder = new StringBuilder(maxWidth);
        for (String cache : cacheList) {
            lastLineBuilder.append(cache);
        }
        appendSpaceToBuilder(lastLineBuilder, maxWidth - lastLineBuilder.length());
        lineList.add(lastLineBuilder.toString());

        return lineList;
    }

    private static void appendSpaceToBuilder(StringBuilder builder, int spaceNum) {
        for (int i = 0; i < spaceNum; i++) {
            builder.append(' ');
        }
    }


}
