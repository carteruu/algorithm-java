package com.carter.leet;

import com.carter.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
class Item108Test {

    @Test
    void sortedArrayToBST() {
        TreeNode treeNode = new Item108().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        MatcherAssert.assertThat(treeNode.val, Matchers.is(0));
    }
}