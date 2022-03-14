package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item165Test {

    @Test
    void compareVersion() {
        int ans = new Item165().compareVersion("1.01", "1.001");
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void compareVersion3() {
        int ans = new Item165().compareVersion("1.0", "1.0.0");
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void compareVersion2() {
        int ans = new Item165().compareVersion("0.1", "1.1");
        MatcherAssert.assertThat(ans, Matchers.is(-1));
    }

    @Test
    void compareVersion1() {
        int ans = new Item165().compareVersion("1.0.1", "1");
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

}