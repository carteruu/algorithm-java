package com.carter.contest;

import com.carter.ListNode;
import com.carter.leetcode.Item2181;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2181Test {
    @Test
    void mergeNodes() {
        ListNode ans = new Item2181().mergeNodes(new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(0, new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(0, null)))))))));
        MatcherAssert.assertThat(ans.val, Matchers.is(4));
    }
}