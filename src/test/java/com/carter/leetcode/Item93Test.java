package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Item93Test {

    @Test
    void numSubarraysWithSum() {
        List<String> ans = new Item93().restoreIpAddresses("25525511135");
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList("255.255.11.135", "255.255.111.35")));
    }

    @Test
    void numSubarraysWithSum4() {
        List<String> ans = new Item93().restoreIpAddresses("010010");
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList("0.10.0.10", "0.100.1.0")));
    }

    @Test
    void numSubarraysWithSum3() {
        List<String> ans = new Item93().restoreIpAddresses("0000");
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList("0.0.0.0")));
    }

    @Test
    void numSubarraysWithSum2() {
        List<String> ans = new Item93().restoreIpAddresses("1111");
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList("1.1.1.1")));
    }

    @Test
    void numSubarraysWithSum1() {
        List<String> ans = new Item93().restoreIpAddresses("101023");
        MatcherAssert.assertThat(ans, Matchers.is(Arrays.asList("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3")));
    }
}