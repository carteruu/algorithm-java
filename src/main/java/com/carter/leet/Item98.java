package com.carter.leet;

import com.carter.TreeNode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 */
public class Item98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST((long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1, root);
    }

    private boolean isValidBST(long min, long max, TreeNode node) {
        if (node == null) {
            return true;
        }
        if (node.val <= min) {
            return false;
        }
        if (node.val >= max) {
            return false;
        }
        //左子树大于下界,小于当前节点值
        //右子树小于上界,大于当前节点值
        return isValidBST(min, node.val, node.left) && isValidBST(node.val, max, node.right);
    }
}
