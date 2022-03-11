package com.carter.leet;

import com.carter.TreeNode;

public class Item129 {
    private int rs = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return rs;
    }

    private void helper(TreeNode node, int pre) {
        if (node == null) {
            return;
        }
        int v = pre * 10 + node.val;
        if (node.left == null && node.right == null) {
            this.rs += v;
            return;
        }
        helper(node.left, v);
        helper(node.right, v);
    }
}
