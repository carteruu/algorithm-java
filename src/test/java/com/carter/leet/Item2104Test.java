package com.carter.leet;

import com.carter.leet.Item2104;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2104Test {
    @Test
    void test1(){
        long ans = new Item2104().subArrayRanges(new int[]{4, -2, -3, 4, 1});
        MatcherAssert.assertThat(ans, Matchers.is(59L));
    }
}