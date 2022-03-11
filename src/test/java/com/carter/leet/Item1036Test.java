package com.carter.leet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item1036Test {

    @Test
    void isEscapePossible() {
        boolean ans = new Item1036().isEscapePossible(new int[][]{{887968, 76029}, {478040, 100615}, {413693, 211521}, {84037, 225089}, {516868, 914974}, {161225, 96123}, {320456, 162051}, {70328, 776373}, {642302, 711843}, {115275, 37429}, {499329, 577780}, {735068, 364357}, {345167, 829298}, {135661, 972336}, {61002, 836637}, {951394, 543688}, {412217, 135798}, {710786, 140643}, {753732, 863686}, {774842, 591769}, {993338, 581144}, {153690, 512200}, {705935, 957690}, {140374, 898192}, {103638, 250560}},
                new int[]{147020, 428481},
                new int[]{197254, 373912});
        MatcherAssert.assertThat(ans, Matchers.is(true));
    }
}