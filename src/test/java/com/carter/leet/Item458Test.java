package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item458Test {

    @Test
    void poorPigs() {
        int ans = new Item458().poorPigs(1000, 15, 60);
        MatcherAssert.assertThat(ans, Matchers.is(5));
    }
}