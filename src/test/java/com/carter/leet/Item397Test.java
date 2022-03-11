package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item397Test {

    @Test
    void integerReplacement() {
        int ans = new Item397().integerReplacement(2147483647);
        MatcherAssert.assertThat(ans, Matchers.is(32));
    }

    @Test
    void integerReplacement2() {
        int ans = new Item397().integerReplacement(1);
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void integerReplacement1() {
        int ans = new Item397().integerReplacement(2);
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }
}