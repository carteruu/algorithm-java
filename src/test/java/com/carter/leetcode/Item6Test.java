package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item6Test {

    @Test
    void convert() {
        String ans = new Item6().convert("PAYPALISHIRING", 4);
        MatcherAssert.assertThat(ans, Matchers.is("PINALSIGYAHRPI"));
    }

    @Test
    void convert2() {
        String ans = new Item6().convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.", 3);
        MatcherAssert.assertThat(ans, Matchers.is("Aiosrhem,tseoihartaaeeriwgrlasasnoctaoieplnrmiaodprs,ubroohreunefnttacneedhsmwynihrieto,iheeaalwnefrdutettpntainnwrdvdr.adew,anereqcustbaeeitdcntnlocojmsuuoddis"));
    }

    @Test
    void convert1() {
        String ans = new Item6().convert("PAYPALISHIRING", 3);
        MatcherAssert.assertThat(ans, Matchers.is("PAHNAPLSIIGYIR"));
    }
}