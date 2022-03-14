package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Item399Test {
    @Test
    void calcEquation() {
        double[] ans = new Item399().calcEquation(
                Arrays.asList(Arrays.asList("a", "e"), Arrays.asList("b", "e")),
                new double[]{4.0, 3.0},
                Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("e", "e"), Arrays.asList("x", "x")));
        MatcherAssert.assertThat(ans, Matchers.is(new double[]{1.33333, 1.0, -1.0}));
    }

    @Test
    void calcEquation1() {
        double[] ans = new Item399().calcEquation(
                Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")),
                new double[]{2.0, 3.0},
                Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x")));
        MatcherAssert.assertThat(ans, Matchers.is(new double[]{6.00000, 0.50000, -1.00000, 1.00000, -1.00000}));
    }
}