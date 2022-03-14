package com.carter.leetcode;

import com.carter.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Item230 {
    int rs, k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return rs;
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        if (k == 0) {
            return;
        }
        k--;
        if (k == 0) {
            rs = node.val;
        }
        helper(node.right);
    }

    public int kthSmallest2(TreeNode root, int k) {
        int countLeft = count(root.left);
        int i = k - 1;
        if (countLeft == i) {
            return root.val;
        } else if (countLeft > i) {
            //在左子树
            return kthSmallest(root.left, k);
        } else {
            //在右子树
            return kthSmallest(root.right, i - countLeft);
        }
    }

    private int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + count(node.left) + count(node.right);
    }

    public int kthSmallest1(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1);
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}
