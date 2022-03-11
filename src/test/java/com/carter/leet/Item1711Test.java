package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item1711Test {

    @Test
    void countPairs() {
        int rs = new Item1711().countPairs(new int[]{1, 3, 5, 7, 9});
        MatcherAssert.assertThat(rs, Matchers.is(4));
    }

    @Test
    void countPairs2() {
        int rs = new Item1711().countPairs(new int[]{2160, 1936, 3, 29, 27, 5, 2503, 1593, 2, 0, 16, 0, 3860, 28908, 6, 2, 15, 49, 6246, 1946, 23, 105, 7996, 196, 0, 2, 55, 457, 5, 3, 924, 7268, 16, 48, 4, 0, 12, 116, 2628, 1468});
        MatcherAssert.assertThat(rs, Matchers.is(53));
    }

    @Test
    void countPairs1() {
        int rs = new Item1711().countPairs(new int[]{1, 1, 1, 3, 3, 3, 7});
        MatcherAssert.assertThat(rs, Matchers.is(15));
    }
}