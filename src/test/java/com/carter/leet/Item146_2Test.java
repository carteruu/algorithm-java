package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item146_2Test {
    @Test
    void test1() {
        Item146_2.LRUCache lruCache = new Item146_2.LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        MatcherAssert.assertThat(lruCache.get(2), Matchers.is(-1));
    }
}