package com.carter.leet;

import com.carter.TreeNode;

public class Item124 {
    private int rs = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return rs;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = node.val;
        int leftSum = Math.max(helper(node.left), 0);
        int rightSum = Math.max(helper(node.right), 0);

        rs = Math.max(rs, sum + leftSum + rightSum);
        //因为不能重复走一个边,所以只能选择左或者右
        return sum + Math.max(leftSum, rightSum);
    }
}
