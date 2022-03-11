package com.carter.leet;

import com.carter.leet.Item2079;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2079Test {
    @Test
    void wateringPlants() {
        int ans = new Item2079().wateringPlants(new int[]{3, 2, 4, 2, 1}, 6);
        MatcherAssert.assertThat(ans, Matchers.is(17));
    }
}