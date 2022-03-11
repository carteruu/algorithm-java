package com.carter.leet;

import com.carter.NodeFour.Node;

public class Item427 {
    public Node construct(int[][] grid) {
        if (grid == null) {
            return null;
        }
        int rowLen = grid.length;
        if (rowLen == 0) {
            return null;
        }
        int columnLen = grid[0].length;
        if (columnLen == 0) {
            return null;
        }

        int pow = 2;
        while (rowLen > pow || columnLen > pow) {
            pow <<= 1;
        }
        rowLen = pow;
        columnLen = pow;

        return helper(grid, 0, rowLen, 0, columnLen);
    }

    private Node helper(int[][] grid, int i, int j, int k, int l) {
        Node topLeft = null;
        Node topRight = null;
        Node bottomLeft = null;
        Node bottomRight = null;
        if (j - i == 2) {
            if (i < grid.length && k < grid[i].length) {
                topLeft = new Node(grid[i][k] == 1, true);
            }
            if (i < grid.length && k + 1 < grid[i].length) {
                topRight = new Node(grid[i][k + 1] == 1, true);
            }
            if (i + 1 < grid.length && k < grid[i + 1].length) {
                bottomLeft = new Node(grid[i + 1][k] == 1, true);
            }
            if (i + 1 < grid.length && k + 1 < grid[i + 1].length) {
                bottomRight = new Node(grid[i + 1][k + 1] == 1, true);
            }
        } else {
            int rowMid = (j - i) / 2 + i;
            int columnMid = (l - k) / 2 + k;
            topLeft = helper(grid, i, rowMid, k, columnMid);
            topRight = helper(grid, rowMid, j, k, columnMid);
            bottomLeft = helper(grid, i, rowMid, columnMid, j);
            bottomRight = helper(grid, rowMid, j, columnMid, j);
        }

        if (topLeft != null || topRight != null || bottomLeft != null || bottomRight != null) {
            Node node = new Node();
            node.topLeft = topLeft;
            node.topRight = topRight;
            node.bottomLeft = bottomLeft;
            node.bottomRight = bottomRight;
            return node;
        }
        return null;
    }
}
