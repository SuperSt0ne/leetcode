package com.rango.leetcode;

/**
 * <a href="https://leetcode.cn/problems/zigzag-conversion/description/?envType=study-plan-v2&envId=top-interview-150">Z 字形变换</a>
 */
public class N0006ConvertZ {

    public static void main(String[] args) {
        System.out.println(convert1("PAYPALISHIRING", 3));
        System.out.println(convert2("PAYPALISHIRING", 3));
    }

    /**
     * 压缩矩阵空间
     */
    public static String convert2(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        StringBuilder[] mat = new StringBuilder[r];
        for (int i = 0; i < r; i++) {
            mat[i] = new StringBuilder();
        }
        for (int i = 0, x = 0, t = r * 2 - 2; i < n; ++i) {
            mat[x].append(s.charAt(i));
            if (i % t < r - 1) {
                ++x;
            } else {
                --x;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : mat) {
            ans.append(row);
        }
        return ans.toString();
    }

    /**
     * 二维矩阵模拟
     */
    public static String convert1(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        int t = r * 2 - 2; //一个周期数量 t = r + r − 2 -> 2r - 2
        int c = (n + (t - 1) / t) * (r - 1); // 每个周期占用 1 + r - 2 -> r - 1 列;  加 t - 1: 确保即使 n 不是 t 的倍数，也能保证至少包含一个完整的周期
        char[][] mat = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i) {
            mat[x][y] = s.charAt(i);
            if (i % t < r - 1) {
                ++x;
            } else {
                --x;
                ++y;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}
