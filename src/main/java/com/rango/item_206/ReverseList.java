package com.rango.item_206;

import com.rango.ListNode;

/**
 * 反转链表
 *
 * @see <a href="https://leetcode.cn/problems/reverse-linked-list/">链接</a>
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        ListNode data = reverseList_1(n1);
        System.out.println(data);
    }

    public static ListNode reverseList_1(ListNode head) {
        ListNode pre = null;
        ListNode cur;
        while (head != null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }

}
