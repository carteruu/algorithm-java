package com.carter.leetcode;

import com.carter.ListNode;

public class Item2181 {
    public ListNode mergeNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode();
        ListNode dummyTail = dummyHead;
        ListNode s = head;
        head = head.next;
        while (head != null) {
            if (head.val == 0) {
                if (s.val != 0) {
                    dummyTail.next = s;
                    dummyTail = s;
                    s = head;
                }
            } else {
                s.val += head.val;
            }
            head = head.next;
        }
        dummyTail.next = null;
        return dummyHead.next;
    }
}
