package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item494Test {

    @Test
    void findTargetSumWays() {
        int rs = new Item494().findTargetSumWays2(new int[]{1, 1, 1, 1, 1}, 3);
        MatcherAssert.assertThat(rs, Matchers.is(5));
    }

    @Test
    void findTargetSumWays2() {
        int rs = new Item494().findTargetSumWays2(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1);
        MatcherAssert.assertThat(rs, Matchers.is(256));
    }

    @Test
    void findTargetSumWays1() {
        int rs = new Item494().findTargetSumWays2(new int[]{1}, 2);
        MatcherAssert.assertThat(rs, Matchers.is(0));
    }
}