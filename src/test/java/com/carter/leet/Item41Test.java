package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item41Test {

    @Test
    void firstMissingPositive() {
        int res = new Item41().firstMissingPositive(new int[]{1, 2, 0});
        MatcherAssert.assertThat(res, Matchers.is(3));
    }

    @Test
    void firstMissingPositive3() {
        int res = new Item41().firstMissingPositive(new int[]{2, 1});
        MatcherAssert.assertThat(res, Matchers.is(3));
    }

    @Test
    void firstMissingPositive2() {
        int res = new Item41().firstMissingPositive(new int[]{3, 4, -1, 1});
        MatcherAssert.assertThat(res, Matchers.is(2));
    }

    @Test
    void firstMissingPositive1() {
        int res = new Item41().firstMissingPositive(new int[]{7, 8, 9, 11, 12});
        MatcherAssert.assertThat(res, Matchers.is(1));
    }
}