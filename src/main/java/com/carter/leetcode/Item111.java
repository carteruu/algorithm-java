package com.carter.leetcode;
import com.carter.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

public class Item111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> heightQueue = new ArrayDeque<>();
        queue.offer(root);
        heightQueue.offer(1);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            Integer height = heightQueue.poll();
            if (node.left == null && node.right == null) {
                return height;
            }
            if (node.left != null) {
                queue.offer(node.left);
                heightQueue.offer(height + 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                heightQueue.offer(height + 1);
            }
        }
        return 0;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return n(root);
    }

    private int n(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.left == null) {
            return n(node.right) + 1;
        }
        if (node.right == null) {
            return n(node.left) + 1;
        }
        return Math.min(n(node.left), n(node.right)) + 1;
    }
}
