package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1877Test {

    @Test
    void minPairSum() {
        int rs = new Item1877().minPairSum(new int[]{3, 5, 2, 3});
        MatcherAssert.assertThat(rs, Matchers.is(7));
    }
}