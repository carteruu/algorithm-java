package com.carter.interview;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item1625Test {
    @Test
    void lru(){
        Item1625.LRUCache lruCache = new Item1625.LRUCache(2);
    }
}