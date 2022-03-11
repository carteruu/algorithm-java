package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item520Test {

    @Test
    void detectCapitalUse() {
        boolean ans = new Item520().detectCapitalUse("Upper");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void detectCapitalUse4() {
        boolean ans = new Item520().detectCapitalUse("UPpper");
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void detectCapitalUse3() {
        boolean ans = new Item520().detectCapitalUse("UppEr");
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void detectCapitalUse2() {
        boolean ans = new Item520().detectCapitalUse("upper");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void detectCapitalUse1() {
        boolean ans = new Item520().detectCapitalUse("uppEr");
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }
}