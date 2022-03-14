package com.carter.leetcode;

import com.carter.ListNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item19Test {

    @Test
    void removeNthFromEnd() {
        ListNode ans = new Item19().removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))), 2);
        MatcherAssert.assertThat(ans.val, Matchers.is(1));
        MatcherAssert.assertThat(ans.next.next.next.val, Matchers.is(5));
        MatcherAssert.assertThat(ans.next.next.next.next, Matchers.nullValue());
    }

    @Test
    void removeNthFromEnd1() {
        ListNode ans = new Item19().removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))), 5);
        MatcherAssert.assertThat(ans.val, Matchers.is(2));
    }
}