package com.carter.off;

import com.carter.ListNode;

public class Item52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null && tempB != null) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        while (tempA != null) {
            tempA = tempA.next;
            headA = headA.next;
        }
        while (tempB != null) {
            tempB = tempB.next;
            headB = headB.next;
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int diff = len(headA) - len(headB);
        while (diff > 0) {
            headA = headA.next;
            diff--;
        }
        while (diff < 0) {
            headB = headB.next;
            diff++;
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int len(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
