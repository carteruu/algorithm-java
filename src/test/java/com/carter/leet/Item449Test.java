package com.carter.leet;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Item449Test {
    @Test
    void serialize() {
        Item449 item449 = new Item449();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        String serialize = item449.serialize(root);
        TreeNode rs = item449.deserialize(serialize);
        MatcherAssert.assertThat(item449.serialize(rs), Matchers.is(serialize));
    }
}
