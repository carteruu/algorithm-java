package com.carter.leet;
import com.carter.TreeNode;
public class Item1022 {
    private int rs;

    public int sumRootToLeaf(TreeNode root) {
        t(root, 0);
        return rs;
    }

    private void t(TreeNode node, int pre) {
        if (node == null) {
            return;
        }
        int val = (pre << 1) + node.val;
        if (node.left == null && node.right == null) {
            //叶子节点
            rs += val;
            return;
        }
        t(node.left, val);
        t(node.right, val);
    }
}
