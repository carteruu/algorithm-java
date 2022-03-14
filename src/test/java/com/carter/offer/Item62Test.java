package com.carter.offer;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Item62Test {
    @Test
    void lastRemaining() {
        int ans = new Item62().lastRemaining(5, 3);
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void lastRemaining2() {
        int ans = new Item62().lastRemaining(88, 10);
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void lastRemaining1() {
        int ans = new Item62().lastRemaining(10, 17);
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }
}
