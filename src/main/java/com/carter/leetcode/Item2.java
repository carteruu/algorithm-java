package com.carter.leetcode;

import com.carter.ListNode;

import java.util.Stack;
public class Item2 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(9);
        listNode1.next.next = new ListNode(9);
        listNode1.next.next.next = new ListNode(9);
        listNode1.next.next.next.next = new ListNode(9);
        listNode1.next.next.next.next.next = new ListNode(9);
        listNode1.next.next.next.next.next.next = new ListNode(9);

        ListNode listNode2 = new ListNode(9);
        listNode2.next = new ListNode(9);
        listNode2.next.next = new ListNode(9);
        listNode2.next.next.next = new ListNode(9);
        ListNode rs = new Item2().addTwoNumbers2(listNode1, listNode2);
        while (rs != null) {
            System.out.println(rs.val);
            rs = rs.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> rs = new Stack<>();

        ListNode curNode1 = l1;
        while (curNode1 != null) {
            stack1.push(curNode1.val);
            curNode1 = curNode1.next;
        }

        ListNode curNode2 = l2;
        while (curNode2 != null) {
            stack2.push(curNode2.val);
            curNode2 = curNode2.next;
        }

        int carry = 0;
        int len = Math.max(stack1.size(), stack2.size());
        for (int i = 0; i < len; i++) {
            int o1 = 0;
            int o2 = 0;
            if (!stack1.isEmpty()) {
                o1 = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                o2 = stack2.pop();
            }
            int val = o1 + o2 + carry;
            carry = val / 10;
            rs.push(val % 10);
        }
        if (carry > 0) {
            rs.push(carry);
        }

        ListNode head = null;
        while (!rs.isEmpty()) {
            head = new ListNode(rs.pop(), head);
        }
        return head;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int val = l1.val + l2.val;
        ListNode head = new ListNode(val % 10);
        ListNode pre = head;

        ListNode curNode1 = l1.next;
        ListNode curNode2 = l2.next;
        int carry = val / 10;

        while (curNode1 != null || curNode2 != null) {
            int o1 = 0;
            int o2 = 0;
            if (curNode1 != null) {
                o1 = curNode1.val;
                curNode1 = curNode1.next;
            }
            if (curNode2 != null) {
                o2 = curNode2.val;
                curNode2 = curNode2.next;
            }
            val = o1 + o2 + carry;
            pre.next = new ListNode(val % 10);
            pre = pre.next;
            carry = val / 10;
        }
        if (carry > 0) {
            pre.next = new ListNode(carry);
        }
        return head;
    }




}
