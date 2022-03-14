package com.carter.leetcode;

import com.carter.TreeNode;

public class Item222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = 1;
        TreeNode left = root.left;
        while (left != null) {
            leftHeight++;
            left = left.left;
        }
        int rightHeight = 1;
        TreeNode right = root.right;
        while (right != null) {
            rightHeight++;
            right = right.right;
        }
        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
