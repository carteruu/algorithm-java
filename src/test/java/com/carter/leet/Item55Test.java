package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item55Test {

    @Test
    void canJump() {
        boolean ans = new Item55().canJump(new int[]{1, 0});
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void canJump4() {
        boolean ans = new Item55().canJump(new int[]{1, 0, 2});
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void canJump3() {
        boolean ans = new Item55().canJump(new int[]{0});
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void canJump2() {
        boolean ans = new Item55().canJump(new int[]{2, 3, 1, 1, 4});
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void canJump1() {
        boolean ans = new Item55().canJump(new int[]{3, 2, 1, 0, 4});
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

}