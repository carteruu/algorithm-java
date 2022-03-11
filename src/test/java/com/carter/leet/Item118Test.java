package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Item118Test {
    @Test
    void generate() {
        List<List<Integer>> ans = new Item118().generate(1);
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(Arrays.asList(1))));
    }

    @Test
    void generate3() {
        List<List<Integer>> ans = new Item118().generate(2);
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(Arrays.asList(1), Arrays.asList(1, 1))));
    }

    @Test
    void generate2() {
        List<List<Integer>> ans = new Item118().generate(3);
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(Arrays.asList(1), Arrays.asList(1, 1), Arrays.asList(1, 2, 1))));
    }

    @Test
    void generate1() {
        List<List<Integer>> ans = new Item118().generate(5);
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 2, 1),
                Arrays.asList(1, 3, 3, 1),
                Arrays.asList(1, 4, 6, 4, 1)
        )));
    }

}
