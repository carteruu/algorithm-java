package com.carter.off;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item37Test {

    @Test
    void serialize() {
        Item37 item37 = new Item37();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        String serialize = item37.serialize(root);
        TreeNode rs = item37.deserialize(serialize);
        MatcherAssert.assertThat(rs.val, Matchers.is(1));
    }

}