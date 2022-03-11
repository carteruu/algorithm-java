package com.carter.off;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Item53Test {
    @Test
    void maxSubArray() {
        int max = new Item53().search(new int[]{5, 7, 7, 8, 8, 10}, 8);
        MatcherAssert.assertThat(max, Matchers.is(2));
    }

    @Test
    void maxSubArray1() {
        int max = new Item53().search(new int[]{5, 7, 7, 8, 8, 10}, 6);
        MatcherAssert.assertThat(max, Matchers.is(0));
    }


}
