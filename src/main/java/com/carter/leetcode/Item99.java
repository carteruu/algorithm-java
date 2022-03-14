package com.carter.leetcode;

import com.carter.TreeNode;

import java.util.ArrayList;
import java.util.List;
public class Item99 {
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        mid(root, list);
        Integer x = null;
        Integer y = null;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                if (x == null) {
                    x = list.get(i);
                }
                y = list.get(i + 1);
            }
        }
        recover(root, x, y, 2);
    }

    private void recover(TreeNode node, int err1, int err2, int count) {
        if (node == null) {
            return;
        }
        if (node.val == err1 || node.val == err2) {
            node.val = node.val == err1 ? err2 : err1;
            count--;
        }
        if (count == 0) {
            return;
        }
        recover(node.left, err1, err2, count);
        recover(node.right, err1, err2, count);
    }

    private void mid(TreeNode node, List<Integer> a) {
        if (node == null) {
            return;
        }
        mid(node.left, a);
        a.add(node.val);
        mid(node.right, a);
    }
}
