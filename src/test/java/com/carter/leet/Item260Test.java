package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item260Test {

    @Test
    void singleNumber() {
        int[] ans = new Item260().singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        MatcherAssert.assertThat(ans, Matchers.anyOf(Matchers.is(new int[]{3, 5}), Matchers.is(new int[]{5, 3})));
    }

    @Test
    void singleNumber1() {
        int[] ans = new Item260().singleNumber(new int[]{1, -1});
        MatcherAssert.assertThat(ans, Matchers.anyOf(Matchers.is(new int[]{1, -1}), Matchers.is(new int[]{-1, 1})));
    }
}