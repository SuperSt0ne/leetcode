package com.rango;

import com.rango.obj.ListNode;

/**
 * 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class addTwoNums {
    public static void main(String[] args) {
        System.out.println(11 % 10);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        boolean nextIn1 = false;
        while (l1 != null || l2 != null) {
            int v1 = null != l1 ? l1.getVal() : 0;
            int v2 = null != l2 ? l2.getVal() : 0;
            int curVal = (v1 + v2) % 10 + (nextIn1 ? 1 : 0);
            nextIn1 = (v1 + v2) > 10;
            ListNode curNode = new ListNode();
            curNode.setVal(curVal);
            if (head == null) {
                head = tail = new ListNode();
            }
        }
        return null;
    }
}
