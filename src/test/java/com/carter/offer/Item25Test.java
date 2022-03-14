package com.carter.offer;

import com.carter.ListNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item25Test {

    @Test
    void mergeTwoLists() {
        ListNode ans = new Item25().mergeTwoLists(new ListNode(1, new ListNode(2)), new ListNode(1, new ListNode(3)));
        MatcherAssert.assertThat(ans.val, Matchers.is(1));
        MatcherAssert.assertThat(ans.next.val, Matchers.is(1));
        MatcherAssert.assertThat(ans.next.next.val, Matchers.is(2));
        MatcherAssert.assertThat(ans.next.next.next.val, Matchers.is(3));
        MatcherAssert.assertThat(ans.next.next.next.next, Matchers.nullValue());
    }

    @Test
    void mergeTwoLists3() {
        ListNode ans = new Item25().mergeTwoLists(new ListNode(1), null);
        MatcherAssert.assertThat(ans.next, Matchers.nullValue());
    }

    @Test
    void mergeTwoLists2() {
        ListNode ans = new Item25().mergeTwoLists(null, new ListNode(1));
        MatcherAssert.assertThat(ans.next, Matchers.nullValue());
    }

    @Test
    void mergeTwoLists1() {
        ListNode ans = new Item25().mergeTwoLists(null, null);
        MatcherAssert.assertThat(ans, Matchers.nullValue());
    }
}