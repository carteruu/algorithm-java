package com.carter.leet;

import com.carter.off.Item51;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Item51Test {
    @Test
    void reversePairs() {
        int ans = new Item51().reversePairs(new int[]{});
        MatcherAssert.assertThat(ans, Matchers.is(0));
    }

    @Test
    void reversePairs1() {
        int ans = new Item51().reversePairs(new int[]{7, 5, 6, 4});
        MatcherAssert.assertThat(ans, Matchers.is(5));
    }
}
