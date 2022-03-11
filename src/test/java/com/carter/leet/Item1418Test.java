package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Item1418Test {

    @Test
    void displayTable() {
        List<List<String>> rs = new Item1418().displayTable(Arrays.asList(Arrays.asList("David", "3", "Ceviche"),
                Arrays.asList("Corina", "10", "Beef Burrito"),
                Arrays.asList("David", "3", "Fried Chicken"),
                Arrays.asList("Carla", "5", "Water"),
                Arrays.asList("Carla", "5", "Ceviche"),
                Arrays.asList("Rous", "3", "Ceviche")));
        MatcherAssert.assertThat(rs, Matchers.is(Arrays.asList(Arrays.asList("Table", "Beef Burrito", "Ceviche", "Fried Chicken", "Water"),
                Arrays.asList("3", "0", "2", "1", "0"),
                Arrays.asList("5", "0", "1", "0", "1"),
                Arrays.asList("10", "1", "0", "0", "0"))));
    }
}