package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item375Test {

    @Test
    void getMoneyAmount() {
        int ans = new Item375().getMoneyAmount(10);
        MatcherAssert.assertThat(ans, Matchers.is(16));
    }

    @Test
    void getMoneyAmount2() {
        int ans = new Item375().getMoneyAmount(1);
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void getMoneyAmount1() {
        int ans = new Item375().getMoneyAmount(2);
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }
}