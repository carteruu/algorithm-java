package com.carter.js;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Item2178Test {

    @Test
    void maximumEvenSplit() {
        List<Long> ans = new Item2178().maximumEvenSplit(100000000L);
        MatcherAssert.assertThat(ans, Matchers.is(new ArrayList<>()));
    }
}