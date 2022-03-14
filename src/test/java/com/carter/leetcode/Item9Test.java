package com.carter.leetcode;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;

class Item9Test {

    @Test
    void isPalindrome0() {
        boolean palindrome = new Item9().isPalindrome(121);
        assertThat(palindrome, is(true));
    }

    @Test
    void isPalindrome5() {
        boolean palindrome = new Item9().isPalindrome(21312);
        assertThat(palindrome, is(true));
    }

    @Test
    void isPalindrome1() {
        boolean palindrome = new Item9().isPalindrome(-121);
        assertThat(palindrome, is(false));
    }

    @Test
    void isPalindrome2() {
        boolean palindrome = new Item9().isPalindrome(1);
        assertThat(palindrome, is(true));
    }

    @Test
    void isPalindrome3() {
        boolean palindrome = new Item9().isPalindrome(10);
        assertThat(palindrome, is(false));
    }

    @Test
    void isPalindrome4() {
        boolean palindrome = new Item9().isPalindrome(1000021);
        assertThat(palindrome, is(false));
    }
}