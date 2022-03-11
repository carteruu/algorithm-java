package com.carter.leet;

import com.carter.ListNode;

public class Item2074 {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null) {
            return null;
        }
        //组
        int group = 1;
        int groupCnt = 0;
        ListNode groupHead = head;

        ListNode curr = head;
        //当前节点的上一个节点
        ListNode pre = null;
        //已经处理过节点的尾节点
        ListNode tail = null;
        while (curr != null) {
            pre = curr;
            ListNode next = curr.next;
            groupCnt++;
            if (groupCnt == group) {
                //到组的最后一个节点
                if (groupCnt % 2 == 0) {
                    //如果节点数为偶数,翻转
                    this.rev(groupHead, curr);
                    //拼上前面和后面的链表
                    tail.next = curr;
                    groupHead.next = next;
                    //移动尾节点
                    tail = groupHead;
                } else {
                    //不需要翻转,直接移动尾节点
                    tail = curr;
                }
                group++;
                groupCnt = 0;
                groupHead = next;
            }
            curr = next;
        }
        if (groupCnt != 0 && groupCnt % 2 == 0) {
            this.rev(groupHead, pre);
            tail.next = pre;
            groupHead.next = null;
        }
        return head;
    }

    protected void rev(ListNode h, ListNode t) {
        ListNode curr = h;
        ListNode pre = null;
        while (curr != t) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        curr.next = pre;
    }
}
