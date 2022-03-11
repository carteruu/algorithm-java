package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item1816Test {

    @Test
    void truncateSentence() {
        String ans = new Item1816().truncateSentence("a", 1);
        MatcherAssert.assertThat(ans, Matchers.is("a"));
    }

    @Test
    void truncateSentence2() {
        String ans = new Item1816().truncateSentence("a b", 1);
        MatcherAssert.assertThat(ans, Matchers.is("a"));
    }

    @Test
    void truncateSentence1() {
        String ans = new Item1816().truncateSentence("a b", 2);
        MatcherAssert.assertThat(ans, Matchers.is("a b"));
    }
}