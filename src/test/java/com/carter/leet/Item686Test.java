package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item686Test {

    @Test
    void repeatedStringMatch() {
        int ans = new Item686().repeatedStringMatch("abcd", "cdabcdab");
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void repeatedStringMatch5() {
        int ans = new Item686().repeatedStringMatch("aaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void repeatedStringMatch4() {
        int ans = new Item686().repeatedStringMatch("abcd", "abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd");
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }

    @Test
    void repeatedStringMatch3() {
        int ans = new Item686().repeatedStringMatch("a", "aa");
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }

    @Test
    void repeatedStringMatch2() {
        int ans = new Item686().repeatedStringMatch("a", "a");
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void repeatedStringMatch1() {
        int ans = new Item686().repeatedStringMatch("abcd", "treter");
        MatcherAssert.assertThat(ans, Matchers.is(-1));
    }
}