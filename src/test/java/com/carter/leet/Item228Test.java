package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Item228Test {

    @Test
    void summaryRanges() {
        List<String> rs = new Item228().summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        MatcherAssert.assertThat(rs, Matchers.is(Arrays.asList("0->2", "4->5", "7")));
    }

    @Test
    void summaryRanges1() {
        List<String> rs = new Item228().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
        MatcherAssert.assertThat(rs, Matchers.is(Arrays.asList("0", "2->4", "6", "8->9")));
    }
}