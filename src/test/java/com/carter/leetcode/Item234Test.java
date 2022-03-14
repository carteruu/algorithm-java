package com.carter.leetcode;

import com.carter.ListNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item234Test {

    @Test
    void isPalindrome() {
        boolean ans = new Item234().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3))));
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void isPalindrome5() {
        boolean ans = new Item234().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(1))));
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void isPalindrome4() {
        boolean ans = new Item234().isPalindrome(new ListNode(1, new ListNode(2)));
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void isPalindrome3() {
        boolean ans = new Item234().isPalindrome(new ListNode(1, new ListNode(1)));
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void isPalindrome2() {
        boolean ans = new Item234().isPalindrome(new ListNode(1));
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void isPalindrome1() {
        boolean ans = new Item234().isPalindrome(null);
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }
}