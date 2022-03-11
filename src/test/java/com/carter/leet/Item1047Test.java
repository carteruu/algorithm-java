package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item1047Test {

    @Test
    void removeDuplicates() {
        String ans = new Item1047().removeDuplicates("abbaca");
        MatcherAssert.assertThat(ans, Matchers.is("ca"));
    }

    @Test
    void removeDuplicates2() {
        String ans = new Item1047().removeDuplicates("aaaa");
        MatcherAssert.assertThat(ans, Matchers.is(""));
    }

    @Test
    void removeDuplicates1() {
        String ans = new Item1047().removeDuplicates("aaaaaaa");
        MatcherAssert.assertThat(ans, Matchers.is("a"));
    }
}