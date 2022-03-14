package com.carter.leetcode;

import com.carter.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Item95 {

    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        if (start > end) {
            nodeList.add(null);
            return nodeList;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generate(start, i - 1);
            List<TreeNode> rights = generate(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    nodeList.add(cur);
                }
            }
        }
        return nodeList;
    }
}
