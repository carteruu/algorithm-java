package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item299Test {

    @Test
    void getHint() {
        String ans = new Item299().getHint("1807", "7810");
        MatcherAssert.assertThat(ans, Matchers.is("1A3B"));
    }

    @Test
    void getHint3() {
        String ans = new Item299().getHint("1123", "0111");
        MatcherAssert.assertThat(ans, Matchers.is("1A1B"));
    }

    @Test
    void getHint2() {
        String ans = new Item299().getHint("1", "0");
        MatcherAssert.assertThat(ans, Matchers.is("0A0B"));
    }

    @Test
    void getHint1() {
        String ans = new Item299().getHint("1", "1");
        MatcherAssert.assertThat(ans, Matchers.is("1A0B"));
    }
}