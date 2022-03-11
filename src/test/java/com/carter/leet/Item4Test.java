package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item4Test {

    @Test
    void findMedianSortedArrays() {
        double rs = new Item4().findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        MatcherAssert.assertThat(rs, Matchers.is(2.0));
    }

    @Test
    void findMedianSortedArrays1() {
        double rs = new Item4().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        MatcherAssert.assertThat(rs, Matchers.is(2.5));
    }

    @Test
    void findMedianSortedArrays2() {
        double rs = new Item4().findMedianSortedArrays(new int[]{0, 0, 0, 0, 0}, new int[]{-1, 0, 0, 0, 0, 0, 1});
        MatcherAssert.assertThat(rs, Matchers.is(0.0));
    }
}