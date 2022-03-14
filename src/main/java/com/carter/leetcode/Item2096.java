package com.carter.leetcode;

import com.carter.TreeNode;

public class Item2096 {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        //从根节点到起点节点和终点节点的路径
        StringBuilder start = new StringBuilder();
        dest(start, root, startValue);
        StringBuilder dest = new StringBuilder();
        dest(dest, root, destValue);
        //删除相同的前缀
        while (start.length() > 0 && dest.length() > 0) {
            if (start.charAt(0) != dest.charAt(0)) {
                break;
            }
            start.deleteCharAt(0);
            dest.deleteCharAt(0);
        }
        //将起点节点的L和R替换成U
        StringBuilder sb = new StringBuilder(start.length());
        for (int j = 0; j < start.length(); j++) {
            sb.append('U');
        }
        sb.append(dest);
        return sb.toString();
    }

    public String getDirections1(TreeNode root, int startValue, int destValue) {
        TreeNode a = ancestor(root, startValue, destValue);
        StringBuilder sbDest = new StringBuilder();
        dest(sbDest, a, destValue);

        StringBuilder sbStart = new StringBuilder();
        start(sbStart, a, startValue);
        return sbStart.toString() + sbDest.toString();
    }

    /**
     * 从根节点到目标节点的路径,前序遍历
     *
     * @param sb
     * @param node
     * @param val
     * @return
     */
    private boolean dest(StringBuilder sb, TreeNode node, int val) {
        if (node == null) {
            return false;
        }
        if (node.val == val) {
            return true;
        }
        sb.append('L');
        if (dest(sb, node.left, val)) {
            return true;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append('R');
        if (dest(sb, node.right, val)) {
            return true;
        }
        sb.deleteCharAt(sb.length() - 1);
        return false;
    }

    /**
     * 开始节点的路径
     *
     * @param node
     * @param startValue
     * @return
     */
    private boolean start(StringBuilder sbStart, TreeNode node, int startValue) {
        if (node == null) {
            return false;
        }
        if (node.val == startValue) {
            return true;
        }
        sbStart.append("U");
        if (start(sbStart, node.left, startValue)) {
            return true;
        }
        if (start(sbStart, node.right, startValue)) {
            return true;
        }
        return false;
    }

    /**
     * 找出最近的公共祖先节点
     *
     * @param node
     * @param startValue
     * @param destValue
     * @return
     */
    private TreeNode ancestor(TreeNode node, int startValue, int destValue) {
        if (node == null) {
            return null;
        }
        if (node.val == startValue || node.val == destValue) {
            return node;
        }
        TreeNode left = ancestor(node.left, startValue, destValue);
        TreeNode right = ancestor(node.right, startValue, destValue);
        if (left != null && right != null) {
            return node;
        }
        return left != null ? left : right;
    }
}
