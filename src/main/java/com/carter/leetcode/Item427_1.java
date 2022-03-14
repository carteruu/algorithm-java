package com.carter.leetcode;

import com.carter.NodeFour.Node;

public class Item427_1 {
    public Node construct(int[][] grid) {
        if (grid == null) {
            return null;
        }
        return helper(grid, 0, grid.length, 0, grid[0].length);
    }

    private Node helper(int[][] grid, int i, int j, int k, int l) {
        //先判断包含的值是否都相同
        boolean[] same = same(grid, i, j, k, l);
        if (same[0]) {
            //是，直接构建叶子节点，返回
            return new Node(same[1],true);
        }
        Node node = new Node();
        int rowMid = (j - i) / 2 + i;
        int columnMid = (l - k) / 2 + k;
        node.topLeft = helper(grid, i, rowMid, k, columnMid);
        node.topRight = helper(grid, i, rowMid, columnMid, l);
        node.bottomLeft = helper(grid, rowMid, j, k, columnMid);
        node.bottomRight = helper(grid, rowMid, j, columnMid, l);
        return node;
    }

    private boolean[] same(int[][] grid, int i, int j, int k, int l) {
        int temp = grid[i][k];
        for (int m = i; m < j; m++) {
            for (int n = k; n < l; n++) {
                if (temp != grid[m][n]) {
                    return new boolean[]{false};
                }
            }
        }
        return new boolean[]{true, temp == 1};
    }
}
