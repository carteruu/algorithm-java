package com.carter.leet;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;

class Item1863Test {

    @Test
    void subsetXORSum() {
        int rs = new Item1863().subsetXORSum(new int[]{1, 3});
        assertThat(rs, is(6));
    }

    @Test
    void subsetXORSum1() {
        int rs = new Item1863().subsetXORSum(new int[]{5, 1, 6});
        assertThat(rs, is(28));
    }
}