package com.carter.leet;

import com.carter.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
public class Item101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(root.left);
        Queue<TreeNode> q2 = new LinkedList<>();
        q2.offer(root.right);
        while (q1.size() > 0) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            q1.offer(node1.left);
            q1.offer(node2.right);
            q2.offer(node1.right);
            q2.offer(node2.left);
        }
        return q2.isEmpty();
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
