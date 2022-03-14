package com.carter.leetcode;

import com.carter.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Item23 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            priorityQueue.offer(node);
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        while (priorityQueue.size() > 0) {
            ListNode poll = priorityQueue.poll();
            tail.next = poll;
            tail = poll;
            if (poll.next != null) {
                priorityQueue.offer(poll.next);
            }
        }
        return head.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        Integer minIdx = null;
        ListNode head = new ListNode();
        ListNode tail = head;
        int length = lists.length;
        while (true) {
            for (int i = 0; i < length; i++) {
                ListNode node = lists[i];
                if (node == null) {
                    continue;
                }
                if (minIdx == null || node.val < lists[minIdx].val) {
                    minIdx = i;
                }
            }
            if (minIdx == null) {
                break;
            }
            tail.next = lists[minIdx];
            tail = lists[minIdx];
            lists[minIdx] = lists[minIdx].next;
            if (lists[minIdx] == null) {
                lists[minIdx] = lists[length - 1];
                length--;
            }
            minIdx = null;
        }
        return head.next;
    }
}
