package com.carter.leetcode;

import com.carter.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class Item449 {
    // Encodes a tree to a single string.
    private static final String seq = ",";
    private static final String nullFlag = "#";

    public String serialize(TreeNode root) {
        if (root == null) {
            return nullFlag;
        }
        return root.val + seq + serialize(root.left) + seq + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        return deserialize(data.split(seq), new AtomicInteger(0));
    }

    private TreeNode deserialize(String[] arr, AtomicInteger i) {
        if (i.intValue() >= arr.length || nullFlag.equals(arr[i.intValue()])) {
            i.incrementAndGet();
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[i.intValue()]));
        i.incrementAndGet();
        node.left = deserialize(arr, i);
        node.right = deserialize(arr, i);
        return node;
    }
}
