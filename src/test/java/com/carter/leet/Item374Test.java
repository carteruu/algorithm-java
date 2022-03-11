package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item374Test {

    @Test
    void guessNumber() {
        int res = new Item374().guessNumber(8);
        MatcherAssert.assertThat(res, Matchers.is(4));
    }
}