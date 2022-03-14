package com.carter.offer;


import com.carter.TreeNode;

public class Item37 {
    private static final char nullFlag = (char) (0);

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(nullFlag);
            return;
        }
        sb.append((char) (node.val + 1001));
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(data, new int[1]);
    }

    private TreeNode deserialize(String nodeStr, int[] idx) {
        char str = nodeStr.charAt(idx[0]);
        idx[0]++;
        if (nullFlag == str) {
            return null;
        }
        TreeNode node = new TreeNode(str - 1001);
        node.left = deserialize(nodeStr, idx);
        node.right = deserialize(nodeStr, idx);
        return node;
    }
}
