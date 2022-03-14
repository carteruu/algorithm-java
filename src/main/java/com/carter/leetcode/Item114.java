package com.carter.leetcode;

import com.carter.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Item114 {
    public void flatten(TreeNode root) {
        if (null == root) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode r = root.right;
        TreeNode l = root.left;
        root.left = null;
        root.right = l;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = r;
    }

    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        helper(root, list);

        TreeNode node = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            node.right = list.get(i);
            node.left = null;
            node = node.right;
        }
    }

    private void helper(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        helper(node.left, list);
        helper(node.right, list);
    }
}
