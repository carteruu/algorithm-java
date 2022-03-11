package com.carter.leet;

import com.carter.TreeNode;

import java.util.*;

public class Item145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        helper(root, rs);
        return rs;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        helper(node.left, list);
        helper(node.right, list);
        list.add(node.val);
    }
}
