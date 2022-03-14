package com.carter.leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item1744Test {

    @Test
    void canEat() {
        boolean[] booleans = new Item1744().canEat(new int[]{7, 4, 5, 3, 8}, new int[][]{{0, 2, 2}, {4, 2, 4}, {2, 13, 1000000000}});
        MatcherAssert.assertThat(booleans, Matchers.is(new boolean[]{true, false, true}));
    }

    @Test
    void canEat3() {
        boolean[] booleans = new Item1744().canEat(new int[]{0}, new int[][]{{0, 0, 1}});
        MatcherAssert.assertThat(booleans, Matchers.is(new boolean[]{false}));
    }

    @Test
    void canEat2() {
        boolean[] booleans = new Item1744().canEat(new int[]{5215, 14414, 67303, 93431, 44959, 34974, 22935, 64205, 28863, 3436, 45640, 34940, 38519, 5705, 14594, 30510, 4418, 87954, 8423, 65872, 79062, 83736, 47851, 64523, 15639, 19173, 88996, 97578, 1106, 17767, 63298, 8620, 67281, 76666, 50386, 97303, 26476, 95239, 21967, 31606, 3943, 33752, 29634, 35981, 42216, 88584, 2774, 3839, 81067, 59193, 225, 8289, 9295, 9268, 4762, 2276, 7641, 3542, 3415, 1372, 5538, 878, 5051, 7631, 1394, 5372, 2384, 2050, 6766, 3616, 7181, 7605, 3718, 8498, 7065, 1369, 1967, 2781, 7598, 6562, 7150, 8132, 1276, 6656, 1868, 8584, 9442, 8762, 6210, 6963, 4068, 1605, 2780, 556, 6825, 4961, 4041, 4923, 8660, 4114},
                new int[][]{{91, 244597, 840227137}});
        MatcherAssert.assertThat(booleans, Matchers.is(new boolean[]{true}));
    }

    @Test
    void canEat1() {
        boolean[] booleans = new Item1744().canEat(new int[]{10, 11, 42, 42, 49, 14, 44, 33, 13, 49, 32, 19, 48, 36, 25, 38, 32, 45, 30, 21, 13, 45, 39, 12, 12, 25, 26, 18, 35, 28, 1, 31, 14, 16, 38, 49, 26, 33, 39, 39, 7, 31, 20, 8, 49, 36, 6, 1, 32, 2, 35, 10, 31, 37, 13, 43, 26},
                new int[][]{{42, 1228, 10}});
        MatcherAssert.assertThat(booleans, Matchers.is(new boolean[]{true}));
    }
}