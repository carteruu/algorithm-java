package com.carter.interview;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1001Test {

    @Test
    void merge() {
        int[] ans = {1, 2, 3, 0, 0, 0};
        new Item1001().merge(ans, 3, new int[]{2, 5, 6}, 3);
        MatcherAssert.assertThat(ans, Matchers.is(new int[]{1, 2, 2, 3, 5, 6}));
    }
}