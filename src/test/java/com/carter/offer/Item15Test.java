package com.carter.offer;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item15Test {

    @Test
    void hammingWeight() {
        int rs = new Item15().hammingWeight(0b00000000000000000000000000001011);
        MatcherAssert.assertThat(rs, Matchers.is(3));
    }

    @Test
    void hammingWeight2() {
        int rs = new Item15().hammingWeight(0b11111111111111111111111111111101);
        MatcherAssert.assertThat(rs, Matchers.is(31));
    }

    @Test
    void hammingWeight1() {
        int rs = new Item15().hammingWeight(9);
        MatcherAssert.assertThat(rs, Matchers.is(2));
    }
}