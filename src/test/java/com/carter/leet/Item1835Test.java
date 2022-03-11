package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item1835Test {

    @Test
    void getXORSum() {
        int xorSum = new Item1835().getXORSum(new int[]{}, new int[]{});
        MatcherAssert.assertThat(xorSum, Matchers.is(0));
    }

    @Test
    void getXORSum2() {
        int xorSum = new Item1835().getXORSum(new int[]{}, new int[]{});
        MatcherAssert.assertThat(xorSum, Matchers.is(0));
    }

    @Test
    void getXORSum1() {
        int xorSum = new Item1835().getXORSum(new int[]{1, 2, 3}, new int[]{6, 5});
        MatcherAssert.assertThat(xorSum, Matchers.is(0));
    }
}