package com.carter.leetcode;

import com.carter.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Item257_1 {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        helper(root, "", list);
        return list;
    }

    private void helper(TreeNode node, String prefix, List<String> list) {
        if (node == null) {
            return;
        }
        String str = prefix + node.val;
        if (node.left == null && node.right == null) {
            list.add(str);
            return;
        }
        str += "->";
        helper(node.left, str, list);
        helper(node.right, str, list);
    }
}
