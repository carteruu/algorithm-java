package com.carter.leet;

import com.carter.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Item437_2 {
    int count = 0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        map.put(0, 1);
        dfs(root, targetSum, 0);
        return count;
    }


    public void dfs(TreeNode root, int targetSum, int pre) {
        if (root == null) {
            return;
        }
        pre += root.val;
        if (map.containsKey(pre - targetSum)) {
            count += map.get(pre - targetSum);
        }
        if (!map.containsKey(pre)) {
            map.put(pre, 1);
        } else {
            map.put(pre, map.get(pre) + 1);
        }
        dfs(root.left, targetSum, pre);
        dfs(root.right, targetSum, pre);
        map.put(pre, map.get(pre) - 1);
    }
}
