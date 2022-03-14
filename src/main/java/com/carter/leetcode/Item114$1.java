package com.carter.leetcode;

import com.carter.TreeNode;

import java.util.*;

public class Item114$1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return rs;
        }

        stack.push(root);
        while (stack.size() > 0) {
            TreeNode pop = stack.pop();
            rs.add(pop.val);
            if (pop.right != null) {
                stack.add(pop.right);
            }
            if (pop.left != null) {
                stack.add(pop.left);
            }
        }
        return rs;
    }

    private final List<Integer> rs = new ArrayList<>();

    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) {
            return rs;
        }
        rs.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return rs;
    }
}
