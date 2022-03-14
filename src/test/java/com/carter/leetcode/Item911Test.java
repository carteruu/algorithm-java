package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item911Test {
    @Test
    void topVotedCandidate() {
        Item911.TopVotedCandidate topVotedCandidate = new Item911.TopVotedCandidate(new int[]{0, 0, 0, 0, 1}, new int[]{0, 6, 39, 52, 75});
        MatcherAssert.assertThat(topVotedCandidate.q(45), Matchers.is(0));
        MatcherAssert.assertThat(topVotedCandidate.q(49), Matchers.is(0));
        MatcherAssert.assertThat(topVotedCandidate.q(59), Matchers.is(0));
        MatcherAssert.assertThat(topVotedCandidate.q(68), Matchers.is(0));
        MatcherAssert.assertThat(topVotedCandidate.q(42), Matchers.is(0));
        MatcherAssert.assertThat(topVotedCandidate.q(37), Matchers.is(0));
        MatcherAssert.assertThat(topVotedCandidate.q(99), Matchers.is(0));
        MatcherAssert.assertThat(topVotedCandidate.q(26), Matchers.is(0));
        MatcherAssert.assertThat(topVotedCandidate.q(78), Matchers.is(0));
        MatcherAssert.assertThat(topVotedCandidate.q(43), Matchers.is(0));
    }

    @Test
    void topVotedCandidate2() {
        Item911.TopVotedCandidate topVotedCandidate = new Item911.TopVotedCandidate(new int[]{0, 1, 0, 1, 1}, new int[]{24, 29, 31, 76, 81});
        MatcherAssert.assertThat(topVotedCandidate.q(28), Matchers.is(0));
        MatcherAssert.assertThat(topVotedCandidate.q(24), Matchers.is(0));
        MatcherAssert.assertThat(topVotedCandidate.q(29), Matchers.is(1));
        MatcherAssert.assertThat(topVotedCandidate.q(77), Matchers.is(1));
        MatcherAssert.assertThat(topVotedCandidate.q(30), Matchers.is(1));
        MatcherAssert.assertThat(topVotedCandidate.q(25), Matchers.is(0));
        MatcherAssert.assertThat(topVotedCandidate.q(76), Matchers.is(1));
        MatcherAssert.assertThat(topVotedCandidate.q(75), Matchers.is(0));
        MatcherAssert.assertThat(topVotedCandidate.q(81), Matchers.is(1));
        MatcherAssert.assertThat(topVotedCandidate.q(80), Matchers.is(1));
    }

    @Test
    void topVotedCandidate1() {
        Item911.TopVotedCandidate topVotedCandidate = new Item911.TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        MatcherAssert.assertThat(topVotedCandidate.q(3), Matchers.is(0));
        MatcherAssert.assertThat(topVotedCandidate.q(12), Matchers.is(1));
        MatcherAssert.assertThat(topVotedCandidate.q(25), Matchers.is(1));
        MatcherAssert.assertThat(topVotedCandidate.q(15), Matchers.is(0));
        MatcherAssert.assertThat(topVotedCandidate.q(24), Matchers.is(0));
        MatcherAssert.assertThat(topVotedCandidate.q(8), Matchers.is(1));
    }
}