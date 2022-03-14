package com.carter.leetcode;

import com.carter.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Item104 {
    public int maxDepth2(TreeNode root) {
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() > 0) {
            int size = queue.size();
            boolean hasNode = false;
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    hasNode = true;
                    queue.add(node.left);
                    queue.add(node.right);
                }
                size--;
            }
            if (hasNode) {
                maxDepth++;
            }
        }
        return maxDepth;
    }

    public int maxDepth1(TreeNode root) {
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() > 0) {
            List<TreeNode> storey = new ArrayList<>(queue.size());
            storey.addAll(queue);
            queue.clear();

            boolean hasNode = false;
            for (TreeNode node : storey) {
                if (node != null) {
                    hasNode = true;
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (hasNode) {
                maxDepth++;
            }
        }
        return maxDepth;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}


