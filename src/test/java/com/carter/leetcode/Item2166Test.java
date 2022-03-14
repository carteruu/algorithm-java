package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2166Test {
    @Test
    void bitset() {
        Item2166.Bitset bitset = new Item2166.Bitset(2);
        bitset.flip();
        bitset.unfix(1);
        MatcherAssert.assertThat(bitset.toString(), Matchers.is("10"));
        bitset.fix(1);
        bitset.fix(1);
        bitset.unfix(1);
        MatcherAssert.assertThat(bitset.count(), Matchers.is(1));
        MatcherAssert.assertThat(bitset.toString(), Matchers.is("10"));
    }

    @Test
    void bitset3() {
        Item2166.Bitset bitset = new Item2166.Bitset(90);
        bitset.unfix(72);
        bitset.flip();
        MatcherAssert.assertThat(bitset.toString(), Matchers.is("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"));
    }

    @Test
    void bitset2() {
        Item2166.Bitset bitset = new Item2166.Bitset(5);
        bitset.fix(3);
        bitset.fix(1);
        bitset.flip();
        boolean all = bitset.all();
        MatcherAssert.assertThat(all, Matchers.is(false));
        bitset.unfix(0);
        bitset.flip();
        boolean one = bitset.one();
        MatcherAssert.assertThat(one, Matchers.is(true));
        bitset.unfix(0);
        int count = bitset.count();
        MatcherAssert.assertThat(count, Matchers.is(2));
        String s = bitset.toString();
        MatcherAssert.assertThat(s, Matchers.is("01010"));
    }

    @Test
    void bitset1() {
        Item2166.Bitset bitset = new Item2166.Bitset(500);
        bitset.fix(3);
        bitset.fix(1);
        bitset.flip();
        boolean all = bitset.all();
        MatcherAssert.assertThat(all, Matchers.is(false));
        bitset.unfix(0);
        bitset.flip();
        boolean one = bitset.one();
        MatcherAssert.assertThat(one, Matchers.is(true));
        bitset.unfix(0);
        int count = bitset.count();
        MatcherAssert.assertThat(count, Matchers.is(2));
        String s = bitset.toString();
        MatcherAssert.assertThat(s, Matchers.is("01010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    }
}