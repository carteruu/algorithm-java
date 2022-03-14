package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item157Test {

    @Test
    void read() {
        Item157 item157 = new Item157() {

            @Override
            int read4(char[] buf4) {
                buf4[0] = 'a';
                buf4[1] = 'b';
                return 2;
            }
        };
        char[] buf = new char[1];
        int rs = item157.read(buf, 1);
        MatcherAssert.assertThat(buf, Matchers.is(new char[]{'a'}));
        MatcherAssert.assertThat(rs, Matchers.is(1));
    }
}