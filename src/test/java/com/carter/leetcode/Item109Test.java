package com.carter.leetcode;

import com.carter.ListNode;
import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
class Item109Test {

    @Test
    void sortedListToBST() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        TreeNode rs = new Item109().sortedListToBST(head);
        MatcherAssert.assertThat(rs.val, Matchers.is(2));
    }
}