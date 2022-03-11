package com.carter.js;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2171Test {

    @Test
    void minimumRemoval() {
        long ans = new Item2171().minimumRemoval(new int[]{4, 1, 6, 5});
        MatcherAssert.assertThat(ans, Matchers.is(4));
    }
}