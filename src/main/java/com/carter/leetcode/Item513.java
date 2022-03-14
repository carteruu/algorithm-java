package com.carter.leetcode;

import com.carter.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
public class Item513 {
    public int findBottomLeftValue(TreeNode root) {
        //广度优先遍历
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int rs = root.val;
        while (queue.size() > 0) {
            rs = queue.peek().val;
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
        }
        return rs;
    }

    public int findBottomLeftValue1(TreeNode root) {
        int max = max(root) - 1;
        //广度优先遍历
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        for (int i = 0; i < max; i++) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
        }
        return queue.poll().val;
    }

    private int max(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(max(node.right), max(node.left)) + 1;
    }
}
