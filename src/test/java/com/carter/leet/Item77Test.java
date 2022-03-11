package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Item77Test {

    @Test
    void combine() {
        List<List<Integer>> ans = new Item77().combine(4, 2);
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(Arrays.asList(2, 4), Arrays.asList(3, 4), Arrays.asList(2, 3), Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(1, 4))));
    }

    @Test
    void combine1() {
        List<List<Integer>> ans = new Item77().combine(1, 1);
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(Arrays.asList(1))));
    }
}