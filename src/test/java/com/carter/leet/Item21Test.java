package com.carter.leet;

import com.carter.ListNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item21Test {

    @Test
    void megeTwoLists() {
        ListNode l1 = new ListNode(1, new ListNode(2));
        ListNode l2 = new ListNode(1, new ListNode(2));
        ListNode rs = new Item21().mergeTwoLists(l1, l2);
        MatcherAssert.assertThat(rs.val, Matchers.is(1));
        rs = rs.next;
        MatcherAssert.assertThat(rs.val, Matchers.is(1));
        rs = rs.next;
        MatcherAssert.assertThat(rs.val, Matchers.is(2));
        rs = rs.next;
        MatcherAssert.assertThat(rs.val, Matchers.is(2));
    }
}