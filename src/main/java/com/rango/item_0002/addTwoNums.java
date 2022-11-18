package com.rango.item_0002;

import com.rango.obj.ListNode;

/**
 * 两数相加
 *
 * @see <a href="https://leetcode.cn/problems/add-two-numbers/">...</a>
 */
public class addTwoNums {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            int value = sum % 10;
            carry = sum / 10;
            curr = curr.next = new ListNode(value);
        }
        return dummyNode.next;
    }
}
