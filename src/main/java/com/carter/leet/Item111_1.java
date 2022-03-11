package com.carter.leet;

public class Item111_1 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int ans = Integer.MAX_VALUE;
        if (root.left != null) {
            ans = Math.min(ans, minDepth(root.left) + 1);
        }
        if (root.right != null) {
            ans = Math.min(ans, minDepth(root.right) + 1);
        }
        return ans;
    }
}
