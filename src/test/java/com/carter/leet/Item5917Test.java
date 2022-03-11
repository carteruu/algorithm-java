package com.carter.leet;

import com.carter.leet.Item5917;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item5917Test {
    @Test
    void possiblyEquals() {
        boolean ans = new Item5917().possiblyEquals("888w777w797w797w", "887w999w999w779w");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void possiblyEquals4() {
        boolean ans = new Item5917().possiblyEquals("internationalization", "i18n");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void possiblyEquals3() {
        boolean ans = new Item5917().possiblyEquals("l123e", "44");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }

    @Test
    void possiblyEquals2() {
        boolean ans = new Item5917().possiblyEquals("a5b", "c5b");
        MatcherAssert.assertThat(ans, Matchers.is(false));
    }

    @Test
    void possiblyEquals1() {
        boolean ans = new Item5917().possiblyEquals("112s", "g841");
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }
}