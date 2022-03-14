package com.carter.leetcode;

import com.carter.TreeNode;

import java.util.ArrayList;
import java.util.List;
public class Item113 {
    private final List<List<Integer>> rs = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSum(root, targetSum, new ArrayList<>());
        return rs;
    }

    private void pathSum(TreeNode root, int targetSum, List<Integer> list) {
        if (root == null) {
            return;
        }
        int remain = targetSum - root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && remain == 0) {
            rs.add(new ArrayList<>(list));
        }
        pathSum(root.left, remain, list);
        pathSum(root.right, remain, list);
        list.remove(list.size() - 1);
    }
}
