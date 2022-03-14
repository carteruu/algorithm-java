package com.carter.leetcode;

import com.carter.ListNode;
import org.junit.jupiter.api.Test;

class Item2074Test {

    @Test
    void reverseEvenLengthGroups() {
        ListNode ans = new Item2074().reverseEvenLengthGroups(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))));
        System.out.println(1111);
    }

    @Test
    void reverseEvenLengthGroups2() {
        ListNode ans = new Item2074().reverseEvenLengthGroups(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null)))));
        System.out.println(1111);
    }

    @Test
    void reverseEvenLengthGroups1() {
        ListNode ans = new Item2074().reverseEvenLengthGroups(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))));
        System.out.println(1111);
    }

    @Test
    void rev() {
        ListNode tail = new ListNode(6, null);
        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(0, tail)));
        new Item2074().rev(listNode, tail);
        System.out.println(111);
    }
}