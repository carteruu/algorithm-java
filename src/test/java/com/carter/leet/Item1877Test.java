package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item1877Test {

    @Test
    void minPairSum() {
        int rs = new Item1877().minPairSum(new int[]{3, 5, 2, 3});
        MatcherAssert.assertThat(rs, Matchers.is(7));
    }
}