package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item400Test {

    @Test
    void findNthDigit() {
        int ans = new Item400().findNthDigit(3);
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void findNthDigit6() {
        int ans = new Item400().findNthDigit(1111111111);
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void findNthDigit5() {
        int ans = new Item400().findNthDigit(3432);
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void findNthDigit4() {
        int ans = new Item400().findNthDigit(11);
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void findNthDigit3() {
        int ans = new Item400().findNthDigit(12);
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void findNthDigit2() {
        int ans = new Item400().findNthDigit(99);
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }

    @Test
    void findNthDigit1() {
        int ans = new Item400().findNthDigit(100);
        MatcherAssert.assertThat(ans, Matchers.is(5));
    }
}