package com.carter.leet;

import com.carter.ListNode;

import java.util.LinkedList;

public class Item234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, firstEnd = head;
        //找到中点(节点数为偶数时,偏右)
        while (fast != null) {
            firstEnd = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        //翻转后半部分节点
        ListNode pre = reverseList(slow);
        //判断
        ListNode secondHead = pre;
        ListNode firstHead = head;
        boolean ans = true;
        while (secondHead != null) {
            if (firstHead.val != secondHead.val) {
                ans = false;
            }
            secondHead = secondHead.next;
            firstHead = firstHead.next;
        }
        //还原链表
        if (firstEnd != null) {
            firstEnd.next = reverseList(pre);
        }
        return ans;
    }

    /**
     * 翻转链表
     *
     * @param head 头节点
     * @return 新的头节点
     */
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public boolean isPalindrome1(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
