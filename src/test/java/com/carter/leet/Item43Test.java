package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item43Test {

    @Test
    void multiply() {
        String ans = new Item43().multiply("2", "3");
        MatcherAssert.assertThat(ans, Matchers.is("6"));
    }

    @Test
    void multiply4() {
        String ans = new Item43().multiply("999", "0");
        MatcherAssert.assertThat(ans, Matchers.is("0"));
    }

    @Test
    void multiply3() {
        String ans = new Item43().multiply("23", "3");
        MatcherAssert.assertThat(ans, Matchers.is("69"));
    }

    @Test
    void multiply2() {
        String ans = new Item43().multiply("999", "99");
        MatcherAssert.assertThat(ans, Matchers.is("98901"));
    }

    @Test
    void multiply1() {
        String ans = new Item43().multiply("123", "456");
        MatcherAssert.assertThat(ans, Matchers.is("56088"));
    }
}