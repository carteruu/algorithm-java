package com.carter.leet;

import com.carter.TreeNode;

public class Item337_1 {
    public int rob(TreeNode root) {
        int[] rs = dfs(root);
        return Math.max(rs[0], rs[1]);
    }

    /**
     * @param node
     * @return idx-0:选择当前节点的值;idx-1:不选择当前节点的最大值
     */
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        return new int[]{node.val + left[1] + right[1], Math.max(left[0], left[1]) + Math.max(right[0], right[1])};
    }
}
