package com.carter.leet;

import com.carter.ListNode;

public class Item19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while (n >= 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
