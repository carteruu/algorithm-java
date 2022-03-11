package com.carter.leet;

import com.carter.leet.Item2081;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2081Test {

    @Test
    void kMirror() {
        long ans = new Item2081().kMirror(7, 17);
        MatcherAssert.assertThat(ans, Matchers.is(20379000L));
    }

    @Test
    void kMirror1() {
        long ans = new Item2081().kMirror(2, 5);
        MatcherAssert.assertThat(ans, Matchers.is(25L));
    }
}