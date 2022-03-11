package com.carter.leet;
import com.carter.TreeNode;
public class Item110 {
    public boolean isBalanced(TreeNode root) {
        try {
            balancedHeight(root);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private int balancedHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int heightLeft = balancedHeight(node.left);
        int heightRight = balancedHeight(node.right);
        if (Math.abs(heightLeft - heightRight) > 1) {
            throw new IllegalStateException("不是高度平衡二叉树");
        }
        return Math.max(heightLeft, heightRight) + 1;
    }

    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

}
