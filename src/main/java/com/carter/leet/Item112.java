package com.carter.leet;
import com.carter.TreeNode;
public class Item112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int remain = targetSum - root.val;
        if (root.left == null && root.right == null && remain == 0) {
            return true;
        }
        return hasPathSum(root.left, remain) || hasPathSum(root.right, remain);
    }
}
