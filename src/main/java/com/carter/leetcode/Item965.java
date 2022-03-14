package com.carter.leetcode;
import com.carter.TreeNode;
public class Item965 {
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode node, int val) {
        return node == null || (node.val == val && isUnivalTree(node.left, val) && isUnivalTree(node.right, val));
    }
}
