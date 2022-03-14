package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item154Test {

    @Test
    void findMin() {
        int rs = new Item154().findMin(new int[]{2, 2, 2, 0, 1});
        MatcherAssert.assertThat(rs, Matchers.is(0));
    }
}