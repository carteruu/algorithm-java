package com.carter.leetcode;

import com.carter.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Item437 {
    private int rs;

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        sum(root, targetSum, 0, map);
        return rs;
    }

    private void sum(TreeNode node, int targetSum, int sum, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        sum += node.val;
        rs += map.getOrDefault(sum - targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        sum(node.left, targetSum, sum, map);
        sum(node.right, targetSum, sum, map);

        map.put(sum, map.get(sum) - 1);
    }

    public int pathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        dfs(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return rs;
    }

    private void dfs(TreeNode node, int m) {
        if (node == null) {
            return;
        }
        int n = m - node.val;
        if (n == 0) {
            rs++;
        }
        dfs(node.left, n);
        dfs(node.right, n);
    }
}
