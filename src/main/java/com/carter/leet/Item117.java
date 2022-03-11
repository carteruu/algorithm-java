package com.carter.leet;

import com.carter.Node;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 */
public class Item117 {
    public Node connect(Node root) {
        Node cur = root;
        if (cur == null) {
            return null;
        }
        //先找到下一层节点的第一个节点
        Node childFirst = null;
        while (cur != null && childFirst == null) {
            childFirst = cur.left;
            if (childFirst != null) {
                break;
            }
            childFirst = cur.right;
            cur = cur.next;
        }
        //保存起来,方便递归
        Node head = childFirst;
        //找到下一个节点
        Node childNext = null;
        while (cur != null && childNext == null) {
            childNext = cur.left;
            //childNext != childFirst:下一个节点不是头结点
            if (childNext != null && childNext != childFirst) {
                //找到下一个节点时,连接
                childFirst.next = childNext;
                childFirst = childNext;
            }
            childNext = cur.right;
            if (childNext != null && childNext != childFirst) {
                childFirst.next = childNext;
                childFirst = childNext;
                childNext = null;
            }
            cur = cur.next;
        }
        connect(head);
        return root;
    }

    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (queue.size() > 0) {
            Node pre = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (pre != null) {
                    pre.next = poll;
                }
                pre = poll;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return root;
    }
}
