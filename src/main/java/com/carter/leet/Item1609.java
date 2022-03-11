package com.carter.leet;

import java.util.ArrayDeque;
import java.util.Queue;

public class Item1609 {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            TreeNode pre = null;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if ((level + poll.val) % 2 == 0) {
                    return false;
                }
                if (pre != null) {
                    if (level % 2 == 0) {
                        if (pre.val >= poll.val) {
                            //偶数层,需要严格递增
                            return false;
                        }
                    } else {
                        if (pre.val <= poll.val) {
                            //奇数层,需要严格递减
                            return false;
                        }
                    }
                }
                pre = poll;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            level++;
        }
        return true;
    }
}
