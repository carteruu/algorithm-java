package com.carter.leet;

import com.carter.NodeFour;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item427Test {

    @Test
    void construct() {
        NodeFour.Node rs = new Item427_1().construct(new int[][]{
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}});
        NodeFour.Node root = new NodeFour.Node();
        root.topLeft = new NodeFour.Node(true, true);
        root.topRight = new NodeFour.Node();
        root.bottomLeft = new NodeFour.Node(true, true);
        root.bottomRight = new NodeFour.Node(false, true);

        root.topRight.topLeft = new NodeFour.Node(false, true);
        root.topRight.topRight = new NodeFour.Node(false, true);
        root.topRight.bottomLeft = new NodeFour.Node(true, true);
        root.topRight.bottomRight = new NodeFour.Node(true, true);
        MatcherAssert.assertThat(rs, Matchers.is(root));
    }

    @Test
    void construct1() {
        NodeFour.Node rs = new Item427_1().construct(new int[][]{{0, 1}, {1, 0}});
        NodeFour.Node root = new NodeFour.Node();
        root.topLeft = new NodeFour.Node(false,true);
        root.topRight = new NodeFour.Node(true,true);
        root.bottomLeft = new NodeFour.Node(true,true);
        root.bottomRight = new NodeFour.Node(false,true);
        MatcherAssert.assertThat(rs, Matchers.is(root));
    }
}