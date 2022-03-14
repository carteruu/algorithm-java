package com.carter.leetcode;

import com.carter.ListNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item82Test {

    @Test
    void addOperators() {
        ListNode res = new Item82().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2)))));
        MatcherAssert.assertThat(res, Matchers.nullValue());
    }

    @Test
    void addOperators3() {
        ListNode res = new Item82().deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2)))));
        MatcherAssert.assertThat(res.val, Matchers.is(1));
        MatcherAssert.assertThat(res.next, Matchers.nullValue());
    }

    @Test
    void addOperators2() {
        ListNode res = new Item82().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))))));
        MatcherAssert.assertThat(res.val, Matchers.is(3));
    }

    @Test
    void addOperators1() {
        ListNode res = new Item82().deleteDuplicates(new ListNode(1, new ListNode(3, new ListNode(2, new ListNode(2)))));
        MatcherAssert.assertThat(res.val, Matchers.is(1));
        MatcherAssert.assertThat(res.next.val, Matchers.is(3));
    }


}