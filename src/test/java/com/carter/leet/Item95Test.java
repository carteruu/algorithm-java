package com.carter.leet;

import com.carter.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;
class Item95Test {

    @Test
    void generateTrees() {
        List<TreeNode> rs = new Item95().generateTrees(3);
        rs.stream().map(node -> node.val).forEach(System.out::println);
    }
}