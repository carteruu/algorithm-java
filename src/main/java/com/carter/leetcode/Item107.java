package com.carter.leetcode;

import com.carter.TreeNode;

import java.util.Collections;
import java.util.List;
public class Item107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rs = new Item102().levelOrder(root);
        Collections.reverse(rs);
        return rs;
    }
}
