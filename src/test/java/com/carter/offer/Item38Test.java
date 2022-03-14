package com.carter.offer;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item38Test {

    @Test
    void permutation() {
        String[] rs = new Item38().permutation("abc");
        MatcherAssert.assertThat(rs, Matchers.is(new String[]{"abc", "acb", "bac", "bca", "cab", "cba"}));
    }
}