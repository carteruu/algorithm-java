package com.carter.interview;

import com.carter.TreeNode;

public class Item0406 {
    private TreeNode next;
    private boolean flag;

    /**
     * 没看懂 TODO
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        if(p.val >= root.val){
            return inorderSuccessor(root.right, p);
        }
        TreeNode node = inorderSuccessor(root.left,p);
        return node == null ? root : node;
    }
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        backtrack(root, p);
        return next;
    }

    private void backtrack(TreeNode node, TreeNode p) {
        if (node == null || next != null) {
            return;
        }
        inorderSuccessor(node.left, p);
        if (flag) {
            next = node;
            return;
        }
        if (node == p) {
            flag = true;
        }
        inorderSuccessor(node.right, p);
    }
}
