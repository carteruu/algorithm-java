package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item752Test {
    @Test
    void openLock() {
        int rs = new Item752_1().openLock(new String[]{"5557", "5553", "5575", "5535", "5755", "5355", "7555", "3555", "6655", "6455", "4655", "4455", "5665", "5445", "5645", "5465", "5566", "5544", "5564", "5546", "6565", "4545", "6545", "4565", "5656", "5454", "5654", "5456", "6556", "4554", "4556", "6554"}, "5555");
        MatcherAssert.assertThat(rs, Matchers.is(-1));
    }

    @Test
    void openLock3() {
        int rs = new Item752_1().openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888");
        MatcherAssert.assertThat(rs, Matchers.is(-1));
    }

    @Test
    void openLock2() {
        int rs = new Item752_1().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
        MatcherAssert.assertThat(rs, Matchers.is(6));
    }

    @Test
    void openLock1() {
        int rs = new Item752_1().openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888");
        MatcherAssert.assertThat(rs, Matchers.is(-1));
    }
}