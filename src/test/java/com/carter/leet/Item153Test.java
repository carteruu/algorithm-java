package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item153Test {

    @Test
    void findMin() {
        int rs = new Item153().findMin(new int[]{3, 4, 5, 1, 2});
        MatcherAssert.assertThat(rs, Matchers.is(1));
    }

    @Test
    void findMin1() {
        int rs = new Item153().findMin(new int[]{2, 3, 1});
        MatcherAssert.assertThat(rs, Matchers.is(1));
    }
}