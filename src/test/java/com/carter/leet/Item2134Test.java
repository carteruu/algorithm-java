package com.carter.leet;

import com.carter.leet.Item2134;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2134Test {

    @Test
    void minSwaps() {
        int ans = new Item2134().minSwaps(new int[]{0, 1, 1, 1, 0, 0, 1, 1, 0});
        MatcherAssert.assertThat(ans, Matchers.is(2));
    }
}