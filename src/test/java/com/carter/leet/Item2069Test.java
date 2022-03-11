package com.carter.leet;

import com.carter.leet.Item2069.Robot;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class Item2069Test {

    @Test
    void getPos() {
        Robot robot = new Robot(4, 5);
        robot.move(44);
        robot.move(19);
        robot.move(8);
        robot.move(36);
        int[] pos = robot.getPos();
        MatcherAssert.assertThat(pos, Matchers.is(new int[]{1, 4}));
        String dir = robot.getDir();
        MatcherAssert.assertThat(dir, Matchers.is("West"));
//        robot.move(17);
//        pos = robot.getPos();
//        MatcherAssert.assertThat(pos, Matchers.is(new int[]{0, 12}));
//        dir = robot.getDir();
//        MatcherAssert.assertThat(dir, Matchers.is("West"));
    }

    @Test
    void getPos3() {
        Robot robot = new Robot(20, 13);
        robot.move(12);
        robot.move(21);
        int[] pos = robot.getPos();
        MatcherAssert.assertThat(pos, Matchers.is(new int[]{17, 12}));
        String dir = robot.getDir();
        MatcherAssert.assertThat(dir, Matchers.is("West"));
        robot.move(17);
        pos = robot.getPos();
        MatcherAssert.assertThat(pos, Matchers.is(new int[]{0, 12}));
        dir = robot.getDir();
        MatcherAssert.assertThat(dir, Matchers.is("West"));
    }

    @Test
    void getPos2() {
        Robot robot = new Robot(6, 3);
        robot.move(2);
        robot.move(2);
        int[] pos = robot.getPos();
        MatcherAssert.assertThat(pos, Matchers.is(new int[]{4, 0}));
        String dir = robot.getDir();
        MatcherAssert.assertThat(dir, Matchers.is("East"));
        robot.move(2);
        robot.move(1);
        robot.move(4);
        pos = robot.getPos();
        MatcherAssert.assertThat(pos, Matchers.is(new int[]{1, 2}));
        dir = robot.getDir();
        MatcherAssert.assertThat(dir, Matchers.is("West"));
    }

    @Test
    void getPos1() {

    }
}