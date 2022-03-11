package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item136Test {

    @Test
    void singleNumber() {
        int ans = new Item136().singleNumber(new int[]{1, 2, 2});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }
}