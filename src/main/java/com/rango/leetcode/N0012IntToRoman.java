package com.rango.leetcode;

/**
 * <a href="https://leetcode.cn/problems/integer-to-roman/description/?envType=study-plan-v2&envId=top-interview-150">
 * 整数转罗马数字
 * </a>
 * <p>
 * 罗马数字是通过添加从最高到最低的小数位值的转换而形成的。将小数位值转换为罗马数字有以下规则：
 * <p>
 * 如果该值不是以 4 或 9 开头，请选择可以从输入中减去的最大值的符号，将该符号附加到结果，减去其值，然后将其余部分转换为罗马数字。
 * 如果该值以 4 或 9 开头，使用 减法形式，表示从以下符号中减去一个符号，例如 4 是 5 (V) 减 1 (I): IV ，9 是 10 (X) 减 1 (I)：IX。仅使用以下减法形式：4 (IV)，9 (IX)，40 (XL)，90 (XC)，400 (CD) 和 900 (CM)。
 * 只有 10 的次方（I, X, C, M）最多可以连续附加 3 次以代表 10 的倍数。你不能多次附加 5 (V)，50 (L) 或 500 (D)。如果需要将符号附加4次，请使用 减法形式。
 * 给定一个整数，将其转换为罗马数字。
 */
public class N0012IntToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        char[] charArr = String.valueOf(num).toCharArray();
        StringBuilder ans = new StringBuilder();
        int base = 1;
        for (int i = charArr.length - 1; i >= 0; i--) {
            int cur = (charArr[i] - '0') * base;
            String curRoman = parse(cur);
            if ("".equals(curRoman)) {
                int start = cur / base;
                if (start > 5) {
                    curRoman = parse(base * 5);
                    start -= 5;
                }
                for (int k = 1; k <= start; k++) {
                    curRoman = curRoman + parse(base);
                }
            }
            ans.insert(0, curRoman);
            base = base * 10;
        }
        return ans.toString();
    }

    public static String parse(int num) {
        switch (num) {
            case 1:
                return "I";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 40:
                return "XL";
            case 50:
                return "L";
            case 90:
                return "XC";
            case 100:
                return "C";
            case 400:
                return "CD";
            case 500:
                return "D";
            case 900:
                return "CM";
            case 1000:
                return "M";
            default:
                return "";
        }
    }

}
