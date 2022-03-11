package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item342Test {

    @Test
    void isPowerOfFour() {
        boolean powerOfFour = new Item342().isPowerOfFour(4);
        MatcherAssert.assertThat(powerOfFour, Matchers.is(true));
    }

    @Test
    void isPowerOfFour6() {
        boolean powerOfFour = new Item342().isPowerOfFour(1);
        MatcherAssert.assertThat(powerOfFour, Matchers.is(true));
    }

    @Test
    void isPowerOfFour1() {
        boolean powerOfFour = new Item342().isPowerOfFour(5);
        MatcherAssert.assertThat(powerOfFour, Matchers.is(false));
    }

    @Test
    void isPowerOfFour2() {
        boolean powerOfFour = new Item342().isPowerOfFour(0);
        MatcherAssert.assertThat(powerOfFour, Matchers.is(false));
    }

    @Test
    void isPowerOfFour3() {
        boolean powerOfFour = new Item342().isPowerOfFour(16);
        MatcherAssert.assertThat(powerOfFour, Matchers.is(true));
    }

    @Test
    void isPowerOfFour4() {
        boolean powerOfFour = new Item342().isPowerOfFour(-1);
        MatcherAssert.assertThat(powerOfFour, Matchers.is(false));
    }
}