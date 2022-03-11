package com.carter.interview;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item1721Test {

    @Test
    void trap() {
        int res = new Item1721().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        MatcherAssert.assertThat(res, Matchers.is(6));
    }

    @Test
    void trap1() {
        int res = new Item1721().trap(new int[]{});
        MatcherAssert.assertThat(res, Matchers.is(0));
    }

    @Test
    void trap2() {
        int res = new Item1721().trap(new int[]{0, 1, 2, 1, 0});
        MatcherAssert.assertThat(res, Matchers.is(0));
    }

    @Test
    void trap3() {
        int res = new Item1721().trap(new int[]{1, 0, 1});
        MatcherAssert.assertThat(res, Matchers.is(1));
    }
}