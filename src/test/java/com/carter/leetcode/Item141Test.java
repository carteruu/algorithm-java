package com.carter.leetcode;

import com.carter.ListNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Item141Test {
    @Test
    void hasCycle() {
        boolean res = new Item141().hasCycle(new ListNode(1, new ListNode(2, new ListNode(3))));
        MatcherAssert.assertThat(res, Matchers.is(false));
    }

    @Test
    void hasCycle4() {
        ListNode second = new ListNode(2);
        ListNode head = new ListNode(1, second);
        second.next = head;
        boolean res = new Item141().hasCycle(head);
        MatcherAssert.assertThat(res, Matchers.is(true));
    }

    @Test
    void hasCycle3() {
        ListNode second = new ListNode(2);
        ListNode head = new ListNode(1, second);
        second.next = second;
        boolean res = new Item141().hasCycle(head);
        MatcherAssert.assertThat(res, Matchers.is(true));
    }

    @Test
    void hasCycle2() {
        ListNode third = new ListNode(3);
        ListNode second = new ListNode(2, third);
        ListNode head = new ListNode(1, second);
        third.next = second;
        boolean res = new Item141().hasCycle(head);
        MatcherAssert.assertThat(res, Matchers.is(true));
    }

    @Test
    void hasCycle1() {
        boolean res = new Item141().hasCycle(null);
        MatcherAssert.assertThat(res, Matchers.is(false));
    }
}
