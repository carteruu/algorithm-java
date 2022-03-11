package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item224Test {

    @Test
    void calculate() {
        int ans = new Item224().calculate("1 + 1");
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void calculate3() {
        int ans = new Item224().calculate("- (3 + (4 + 5))");
        MatcherAssert.assertThat(ans, Matchers.is(-12));
    }

    @Test
    void calculate2() {
        int ans = new Item224().calculate(" 2-1 + 2 ");
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void calculate1() {
        int ans = new Item224().calculate("(1+(4+5+2)-3)+(6+8)");
        MatcherAssert.assertThat(ans, Matchers.is(23));
    }
}