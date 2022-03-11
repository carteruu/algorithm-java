package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Item40Test {

    @Test
    void combinationSum2_() {
        List<List<Integer>> ans = new Item40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        MatcherAssert.assertThat(ans.size(), Matchers.is(4));
    }

    @Test
    void combinationSum2_1() {
        List<List<Integer>> ans = new Item40().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        MatcherAssert.assertThat(ans.size(), Matchers.is(2));
    }
}