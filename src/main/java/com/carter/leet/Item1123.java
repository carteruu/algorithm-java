package com.carter.leet;

import com.carter.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
public class Item1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<TreeNode> leaf = new ArrayList<>();
        while (queue.size() > 0) {
            leaf.addAll(queue);
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            if (queue.size() == 0) {
                //找到叶子节点了
                break;
            }
            leaf.clear();
        }
        return lcaDeepestLeaves(root, leaf);
    }

    private TreeNode lcaDeepestLeaves(TreeNode node, List<TreeNode> leaf) {
        if (node == null) {
            return null;
        }
        for (TreeNode child : leaf) {
            if (node == child) {
                return node;
            }
        }
        TreeNode left = lcaDeepestLeaves(node.left, leaf);
        TreeNode right = lcaDeepestLeaves(node.right, leaf);
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return node;
        }
        return left == null ? right : left;
    }
}
