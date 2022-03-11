package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item394Test {

    @Test
    void decodeString() {
        String res = new Item394().decodeString("3[a]2[bc]");
        MatcherAssert.assertThat(res, Matchers.is("aaabcbc"));
    }

    @Test
    void decodeString5() {
        String res = new Item394().decodeString("3[a]");
        MatcherAssert.assertThat(res, Matchers.is("aaa"));
    }

    @Test
    void decodeString4() {
        String res = new Item394().decodeString("a");
        MatcherAssert.assertThat(res, Matchers.is("a"));
    }

    @Test
    void decodeString1() {
        String res = new Item394().decodeString("3[a2[c]]");
        MatcherAssert.assertThat(res, Matchers.is("accaccacc"));
    }

    @Test
    void decodeString2() {
        String res = new Item394().decodeString("2[abc]3[cd]ef");
        MatcherAssert.assertThat(res, Matchers.is("abcabccdcdcdef"));
    }

    @Test
    void decodeString3() {
        String res = new Item394().decodeString("abc3[cd]xyz");
        MatcherAssert.assertThat(res, Matchers.is("abccdcdcdxyz"));
    }
}