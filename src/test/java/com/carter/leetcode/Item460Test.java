package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item460Test {

    @Test
    void test() {
        Item460.LFUCache lfu = new Item460.LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        MatcherAssert.assertThat(lfu.get(1), Matchers.is(1));
        lfu.put(3, 3);
        MatcherAssert.assertThat(lfu.get(2), Matchers.is(-1));
        MatcherAssert.assertThat(lfu.get(3), Matchers.is(3));
        lfu.put(4, 4);
        MatcherAssert.assertThat(lfu.get(1), Matchers.is(-1));
        MatcherAssert.assertThat(lfu.get(3), Matchers.is(3));
        MatcherAssert.assertThat(lfu.get(4), Matchers.is(4));
    }

    @Test
    void test1() {
        Item460.LFUCache lfu = new Item460.LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        lfu.get(1);
        lfu.put(3, 3);
        MatcherAssert.assertThat(lfu.get(2), Matchers.is(-1));
    }
}