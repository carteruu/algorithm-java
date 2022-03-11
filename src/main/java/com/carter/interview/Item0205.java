package com.carter.interview;

import com.carter.ListNode;

public class Item0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode root = new ListNode();
        ListNode cur = root;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = 0;
            int n2 = 0;
            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }

            int val = n1 + n2 + carry;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            carry = val / 10;
        }
        if (carry > 0) {
            cur.next = new ListNode(1);
        }
        return root.next;
    }
}
