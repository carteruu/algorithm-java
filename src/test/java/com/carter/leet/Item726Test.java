package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item726Test {

    @Test
    void countOfAtoms() {
        String rs = new Item726().countOfAtoms("H2O");
        MatcherAssert.assertThat(rs, Matchers.is("H2O"));
    }

    @Test
    void countOfAtoms3() {
        String rs = new Item726().countOfAtoms("((HHe28Be26He)9)34");
        MatcherAssert.assertThat(rs, Matchers.is("Be7956H306He8874"));
    }

    @Test
    void countOfAtoms2() {
        String rs = new Item726().countOfAtoms("(NB3)33");
        MatcherAssert.assertThat(rs, Matchers.is("B99N33"));
    }

    @Test
    void countOfAtoms1() {
        String rs = new Item726().countOfAtoms("Mg(OH)2");
        MatcherAssert.assertThat(rs, Matchers.is("H2MgO2"));
    }
}