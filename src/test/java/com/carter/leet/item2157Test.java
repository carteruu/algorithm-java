package com.carter.leet;

import com.carter.js.Js;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class item2157Test {

    @Test
    void test1() {
        int ans = new Js().test();
        MatcherAssert.assertThat(ans, Matchers.is(1));
    }
}