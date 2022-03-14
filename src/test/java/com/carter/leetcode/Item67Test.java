package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item67Test {

    @Test
    void addBinary() {
        String sum = new Item67_1().addBinary("11", "1");
        MatcherAssert.assertThat(sum, Matchers.is("100"));
    }

    @Test
    void addBinary1() {
        String sum = new Item67_1().addBinary("0", "0");
        MatcherAssert.assertThat(sum, Matchers.is("0"));
    }
}