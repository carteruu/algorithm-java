package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item1154Test {

    @Test
    void dayOfYear() {
        int ans = new Item1154().dayOfYear("2019-01-09");
        MatcherAssert.assertThat(ans, Matchers.is(9));
    }

    @Test
    void dayOfYear4() {
        int ans = new Item1154().dayOfYear("2019-02-10");
        MatcherAssert.assertThat(ans, Matchers.is(41));
    }

    @Test
    void dayOfYear3() {
        int ans = new Item1154().dayOfYear("2003-03-01");
        MatcherAssert.assertThat(ans, Matchers.is(60));
    }

    @Test
    void dayOfYear2() {
        int ans = new Item1154().dayOfYear("2004-03-01");
        MatcherAssert.assertThat(ans, Matchers.is(61));
    }

    @Test
    void dayOfYear1() {
        int ans = new Item1154().dayOfYear("2300-03-01");
        MatcherAssert.assertThat(ans, Matchers.is(60));
    }
}