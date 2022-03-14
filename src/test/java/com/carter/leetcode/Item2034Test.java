package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2034Test {
    @Test
    void stockPrice() {
        Item2034.StockPrice2 stockPrice2 = new Item2034.StockPrice2();
        stockPrice2.update(38, 2308);
        stockPrice2.update(47, 7876);
        stockPrice2.update(58, 1866);
        stockPrice2.update(43, 121);
        MatcherAssert.assertThat(stockPrice2.minimum(), Matchers.is(121));
        stockPrice2.update(40, 5339);
        stockPrice2.update(32, 5339);
        stockPrice2.update(43, 6414);
        MatcherAssert.assertThat(stockPrice2.current(), Matchers.is(1866));
        MatcherAssert.assertThat(stockPrice2.maximum(), Matchers.is(7876));
        MatcherAssert.assertThat(stockPrice2.minimum(), Matchers.is(1866));
    }

}