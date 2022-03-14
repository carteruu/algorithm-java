package com.carter.leetcode;

import com.carter.ListNode;

public class Item148 {
    public ListNode sortList(ListNode head) {
        return helper(head)[0];
    }

    private ListNode[] helper(ListNode head) {
        if (head == null || head.next == null) {
            return new ListNode[]{head, head};
        }
        ListNode mid = head;
        head = head.next;
        mid.next = null;
        ListNode dummyHead1 = new ListNode();
        ListNode tail1 = dummyHead1;
        ListNode dummyHead2 = new ListNode();
        ListNode tail2 = dummyHead2;
        while (head != null) {
            if (head.val <= mid.val) {
                tail1.next = head;
                tail1 = head;
            } else {
                tail2.next = head;
                tail2 = head;
            }
            head = head.next;
        }
        tail1.next = null;
        tail2.next = null;
        ListNode[] res1 = helper(dummyHead1.next);
        ListNode[] res2 = helper(dummyHead2.next);
        if (res1[0] == null) {
            mid.next = res2[0];
            res2[0] = mid;
            return res2;
        }
        if (res2[0] == null) {
            res1[1].next = mid;
            res1[1] = mid;
            return res1;
        }
        res1[1].next = mid;
        mid.next = res2[0];
        res1[1] = res2[1];
        return res1;
    }

    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //从中点断开
        pre.next = null;

        ListNode heap1 = sortList2(head);
        ListNode heap2 = sortList2(slow);
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (heap1 != null && heap2 != null) {
            if (heap1.val <= heap2.val) {
                tail.next = heap1;
                tail = heap1;
                heap1 = heap1.next;
            } else {
                tail.next = heap2;
                tail = heap2;
                heap2 = heap2.next;
            }
        }
        if (heap1 != null) {
            tail.next = heap1;
        } else {
            tail.next = heap2;
        }
        return dummyHead.next;
    }
}
