package com.carter.leet;

import com.carter.ListNode;

public class Item82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode newTail = newHead;
        ListNode cur = null;
        boolean isMeet = false;
        while (head != null) {
            if (cur == null || cur.val != head.val) {
                if (isMeet) {
                    newTail.next = cur;
                    newTail = cur;
                }
                cur = head;
                isMeet = true;
            } else {
                isMeet = false;
            }
            head = head.next;
        }
        if (isMeet) {
            newTail.next = cur;
        } else {
            newTail.next = null;
        }
        return newHead.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode newTail = newHead;
        ListNode pre = null;
        int len = 0;
        while (head != null) {
            if (pre == null) {
                pre = head;
                len = 1;
            } else {
                if (pre.val != head.val) {
                    if (len == 1) {
                        //保存上一个节点
                        newTail.next = pre;
                        newTail = pre;
                    }
                    len = 1;
                    pre = head;
                } else {
                    len++;
                }
            }
            head = head.next;
        }
        if (len == 1) {
            newTail.next = pre;
        } else {
            newTail.next = null;
        }
        return newHead.next;
    }
}
