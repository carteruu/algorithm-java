package com.carter.leet;

import com.carter.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
public class Item100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queueP = new LinkedList<>();
        queueP.offer(p);
        Queue<TreeNode> queueQ = new LinkedList<>();
        queueQ.offer(q);
        while (queueP.size() > 0) {
            if (queueQ.isEmpty()) {
                return false;
            }

            TreeNode nodeP = queueP.poll();
            TreeNode nodeQ   = queueQ.poll();
            if (nodeP == null && nodeQ == null) {
                continue;
            }
            if (nodeP == null || nodeQ == null) {
                return false;
            }
            if (nodeP.val != nodeQ.val) {
                return false;
            }

            queueP.offer(nodeP.left);
            queueP.offer(nodeP.right);
            queueQ.offer(nodeQ.left);
            queueQ.offer(nodeQ.right);
        }
        return queueQ.isEmpty();
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree1(p.right, q.right) && isSameTree1(p.left, q.left);
    }
}
