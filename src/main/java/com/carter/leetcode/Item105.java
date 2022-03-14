package com.carter.leetcode;

import com.carter.TreeNode;

import java.util.HashMap;
import java.util.Map;
public class Item105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder.length - 1, 0, map);
    }

    private TreeNode buildTree(int[] preorder, int preLeftIdx, int preRightIdx, int inLeftIdx, Map<Integer, Integer> map) {
        if (preLeftIdx > preRightIdx) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preLeftIdx]);
        Integer nodeInIdx = map.get(preorder[preLeftIdx]);
        int leftLen = nodeInIdx - inLeftIdx;
        node.left = buildTree(preorder, preLeftIdx + 1, preLeftIdx + leftLen, inLeftIdx, map);
        node.right = buildTree(preorder, preLeftIdx + leftLen + 1, preRightIdx, nodeInIdx + 1, map);
        return node;
    }
}
