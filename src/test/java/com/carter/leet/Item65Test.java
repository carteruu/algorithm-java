package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item65Test {

    @Test
    void isNumber() {
        boolean rs = new Item65().isNumber("4532");
        MatcherAssert.assertThat(rs, Matchers.is(true));
    }

    @Test
    void isNumber1() {
        boolean rs = new Item65().isNumber("1a");
        MatcherAssert.assertThat(rs, Matchers.is(false));
    }
}