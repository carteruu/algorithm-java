package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item488Test {
    @Test
    void findMinStep() {
        int ans = new Item488().findMinStep("WWRRBBWW", "WRBRW");
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void findMinStep4() {
        int ans = new Item488().findMinStep("RRYGGYYRRYYGGYRR", "GGBBB");
        MatcherAssert.assertThat(ans, Matchers.is(5));
    }

    @Test
    void findMinStep3() {
        int ans = new Item488().findMinStep("WRRBBW", "RB");
        MatcherAssert.assertThat(ans, Matchers.is(-1));
    }

    @Test
    void findMinStep2() {
        int ans = new Item488().findMinStep("WWRRBBWW", "WRBRW");
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void findMinStep1() {
        int ans = new Item488().findMinStep("G", "GGGGG");
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }
}