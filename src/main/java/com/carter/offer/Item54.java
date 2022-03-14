package com.carter.offer;

import com.carter.TreeNode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Item54 {
    private int res;
    private int rank;

    public int kthLargest(TreeNode root, int k) {
        a(root, k);
        return res;
    }

    private void a(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        a(node.right, k);
        rank++;
        if (rank == k) {
            res = node.val;
            return;
        }
        a(node.left, k);
    }

    public int kthLargest1(TreeNode root, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (minHeap.size() == k && minHeap.peek() < node.val) {
                minHeap.poll();
            }
            if (minHeap.size() < k) {
                minHeap.offer(node.val);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return minHeap.peek();
    }
}
