package com.carter.leetcode;

import com.carter.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Item199 {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> rs = new ArrayList<>();
        if (root == null) {
            return rs;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            int last = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                last = poll.val;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            rs.add(last);
        }
        return rs;
    }
}
