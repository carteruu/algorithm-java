package com.carter.leet;

import com.carter.ListNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Item148Test {
    @Test
    void sortList() {
        ListNode ans = new Item148().sortList(new ListNode(1, new ListNode(-1)));
        MatcherAssert.assertThat(ans.val, Matchers.is(-1));
        MatcherAssert.assertThat(ans.next.val, Matchers.is(1));
        MatcherAssert.assertThat(ans.next.next, Matchers.nullValue());
    }

    @Test
    void sortList2() {
        ListNode ans = new Item148().sortList(new ListNode(3, new ListNode(2, new ListNode(1))));
        MatcherAssert.assertThat(ans.val, Matchers.is(1));
        MatcherAssert.assertThat(ans.next.val, Matchers.is(2));
        MatcherAssert.assertThat(ans.next.next.val, Matchers.is(3));
        MatcherAssert.assertThat(ans.next.next.next, Matchers.nullValue());
    }

    @Test
    void sortList1() {
        ListNode ans = new Item148().sortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))));
        MatcherAssert.assertThat(ans.val, Matchers.is(1));
        MatcherAssert.assertThat(ans.next.val, Matchers.is(2));
        MatcherAssert.assertThat(ans.next.next.val, Matchers.is(3));
        MatcherAssert.assertThat(ans.next.next.next.val, Matchers.is(4));
        MatcherAssert.assertThat(ans.next.next.next.next, Matchers.nullValue());
    }
}
