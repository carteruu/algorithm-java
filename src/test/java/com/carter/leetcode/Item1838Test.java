package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1838Test {

    @Test
    void maxFrequency() {
        int rs = new Item1838().maxFrequency(new int[]{1, 2, 4}, 5);
        MatcherAssert.assertThat(rs, Matchers.is(3));
    }

    @Test
    void maxFrequency1() {
        int rs = new Item1838().maxFrequency(new int[]{1, 4, 8, 13}, 5);
        MatcherAssert.assertThat(rs, Matchers.is(3));
    }

}