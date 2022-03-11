package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item506Test {

    @Test
    void findRelativeRanks() {
        String[] ans = new Item506().findRelativeRanks(new int[]{5, 4, 3, 2, 1});
        MatcherAssert.assertThat(ans, Matchers.is(new String[]{"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"}));
    }
}