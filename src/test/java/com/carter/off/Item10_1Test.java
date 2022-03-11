package com.carter.off;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item10_1Test {

    @Test
    void fib() {
        int res = new Item10_1().fib(0);
        MatcherAssert.assertThat(res, Matchers.is(0));
    }

    @Test
    void fib3() {
        int res = new Item10_1().fib(5);
        MatcherAssert.assertThat(res, Matchers.is(5));
    }

    @Test
    void fib2() {
        int res = new Item10_1().fib(2);
        MatcherAssert.assertThat(res, Matchers.is(1));
    }

    @Test
    void fib1() {
        int res = new Item10_1().fib(1);
        MatcherAssert.assertThat(res, Matchers.is(1));
    }
}