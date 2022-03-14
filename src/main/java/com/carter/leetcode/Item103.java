package com.carter.leetcode;

import com.carter.TreeNode;

import java.util.*;
public class Item103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> rs = new ArrayList<>();
        int depth = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            rs.add(list);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if ((depth & 1) == 1) {
                Collections.reverse(list);
            }
            depth++;
        }
        return rs;
    }
}
