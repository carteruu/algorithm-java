package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item475Test {
    @Test
    void findRadius() {
        int ans = new Item475().findRadius(new int[]{282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923},
                new int[]{823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612});
        MatcherAssert.assertThat(ans, Matchers.is(161834419));
    }

    @Test
    void findRadius3() {
        int ans = new Item475().findRadius(new int[]{1, 2, 3}, new int[]{2});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void findRadius2() {
        int ans = new Item475().findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4});
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }

    @Test
    void findRadius1() {
        int ans = new Item475().findRadius(new int[]{1, 5}, new int[]{2});
        MatcherAssert.assertThat(ans, Matchers.is(3));
    }
}