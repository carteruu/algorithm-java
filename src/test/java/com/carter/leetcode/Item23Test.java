package com.carter.leetcode;

import com.carter.ListNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item23Test {

    @Test
    void mergeKLists() {
        ListNode res = new Item23().mergeKLists(new ListNode[]{

        });
        MatcherAssert.assertThat(res, Matchers.nullValue());
    }

    @Test
    void mergeKLists4() {
        ListNode res = new Item23().mergeKLists(new ListNode[]{
                null
        });
        MatcherAssert.assertThat(res, Matchers.nullValue());
    }

    @Test
    void mergeKLists3() {
        ListNode res = new Item23().mergeKLists(new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6)),
        });
        MatcherAssert.assertThat(res.val, Matchers.is(1));
        res = res.next;
        MatcherAssert.assertThat(res.val, Matchers.is(1));
        res = res.next;
        MatcherAssert.assertThat(res.val, Matchers.is(2));
        res = res.next;
        MatcherAssert.assertThat(res.val, Matchers.is(3));
        res = res.next;
        MatcherAssert.assertThat(res.val, Matchers.is(4));
        res = res.next;
        MatcherAssert.assertThat(res.val, Matchers.is(4));
        res = res.next;
        MatcherAssert.assertThat(res.val, Matchers.is(5));
        res = res.next;
        MatcherAssert.assertThat(res.val, Matchers.is(6));
        res = res.next;
        MatcherAssert.assertThat(res, Matchers.nullValue());
    }

    @Test
    void mergeKLists2() {
        ListNode res = new Item23().mergeKLists(new ListNode[]{
                new ListNode(1, new ListNode(2)),
                new ListNode(1, new ListNode(5)),
                null,
        });
        MatcherAssert.assertThat(res.val, Matchers.is(1));
        res = res.next;
        MatcherAssert.assertThat(res.val, Matchers.is(1));
        res = res.next;
        MatcherAssert.assertThat(res.val, Matchers.is(2));
        res = res.next;
        MatcherAssert.assertThat(res.val, Matchers.is(5));
        res = res.next;
        MatcherAssert.assertThat(res, Matchers.nullValue());
    }
}