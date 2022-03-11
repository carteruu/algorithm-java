package com.carter.leet;

import com.carter.TreeNode;
import org.junit.jupiter.api.Test;
class Item106Test {
    @Test
    void buildTree() {
        TreeNode rs = new Item106().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(rs);
    }
}