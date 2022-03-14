package com.carter.leetcode;

import com.carter.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Item257 {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        helper(root, new StringBuilder(root.val + ""), list);
        return list;
    }

    private void helper(TreeNode node, StringBuilder prefix, List<String> list) {
        if (node.left == null && node.right == null) {
            list.add(prefix.toString());
            return;
        }
        if (node.left != null) {
            int length = prefix.length();
            helper(node.left, prefix.append("->").append(node.left.val), list);
            prefix.delete(length, prefix.length());
        }
        if (node.right != null) {
            int length = prefix.length();
            helper(node.right, prefix.append("->").append(node.right.val), list);
            prefix.delete(length, prefix.length());
        }
    }
}
