package com.carter.off;

import com.carter.ListNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item52Test {

    @Test
    void getIntersectionNode() {
        ListNode headA = new ListNode(10);
        ListNode headB = new ListNode(20);
        ListNode rs = new Item52().getIntersectionNode(headA, headB);
        MatcherAssert.assertThat(rs, Matchers.nullValue());
    }

    @Test
    void getIntersectionNode1() {
        ListNode headA = new ListNode(10);
        ListNode headB = new ListNode(20);
        headA.next = headB;
        ListNode rs = new Item52().getIntersectionNode(headA, headB);
        MatcherAssert.assertThat(rs, Matchers.is(headB));
    }
}