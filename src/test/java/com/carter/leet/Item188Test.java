package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item188Test {

    @Test
    void maxProfit() {
        int rs = new Item188().maxProfit(2, new int[]{2, 4, 1});
        MatcherAssert.assertThat(rs, Matchers.is(2));
    }
}