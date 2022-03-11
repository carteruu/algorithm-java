package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item930Test {

    @Test
    void numSubarraysWithSum() {
        int rs = new Item930().numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2);
        MatcherAssert.assertThat(rs, Matchers.is(4));
    }

    @Test
    void numSubarraysWithSum1() {
        int rs = new Item930().numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0);
        MatcherAssert.assertThat(rs, Matchers.is(15));
    }
}