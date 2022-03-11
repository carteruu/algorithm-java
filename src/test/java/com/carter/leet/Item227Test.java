package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item227Test {

    @Test
    void calculate() {
        int ans = new Item227().calculate("3+2*2");
        MatcherAssert.assertThat(ans, Matchers.is(7));
    }

    @Test
    void calculate4() {
        int ans = new Item227().calculate("(3+2)*2");
        MatcherAssert.assertThat(ans, Matchers.is(10));
    }

    @Test
    void calculate3() {
        int ans = new Item227().calculate("14/3*2");
        MatcherAssert.assertThat(ans, Matchers.is(8));
    }

    @Test
    void calculate2() {
        int ans = new Item227().calculate(" 3/2 ");
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void calculate1() {
        int ans = new Item227().calculate(" 3+5 / 2 ");
        MatcherAssert.assertThat(ans, Matchers.is(5));
    }
}