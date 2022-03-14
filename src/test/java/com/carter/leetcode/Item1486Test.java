package com.carter.leetcode;

import org.junit.jupiter.api.Test;

import org.hamcrest.MatcherAssert;

import static org.hamcrest.Matchers.is;

class Item1486Test {

    @Test
    void xorOperation0() {
        int rs = new Item1486().xorOperation(5, 0);
        MatcherAssert.assertThat(rs, is(8));
    }

    @Test
    void xorOperation1() {
        int rs = new Item1486().xorOperation(4, 3);
        MatcherAssert.assertThat(rs, is(8));
    }
}