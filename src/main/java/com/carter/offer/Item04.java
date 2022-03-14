package com.carter.offer;

public class Item04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return dfs(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    /**
     * @param matrix
     * @param target
     * @param t      起始行的下标
     * @param b      结束行的下标
     * @param l      起始列的下标
     * @param r      结束列的下标
     * @return 是否存在
     */
    private boolean dfs(int[][] matrix, int target, int t, int b, int l, int r) {
        if (t > b || l > r) {
            return false;
        }
        int midRow = (b - t) / 2 + t;
        int midCol = (r - l) / 2 + l;
        if (matrix[midRow][midCol] == target) {
            //存在
            return true;
        } else if (matrix[midRow][midCol] < target) {
            //中间的元素比目标小,搜索右下角,右上角,左下角
            return dfs(matrix, target, midRow + 1, b, midCol + 1, r) ||
                    dfs(matrix, target, t, midRow, midCol + 1, r) ||
                    dfs(matrix, target, midRow + 1, b, l, midCol);
        } else {
            //中间的元素比目标小,搜索左上角,右上角,左下角
            return dfs(matrix, target, t, midRow - 1, l, midCol - 1) ||
                    dfs(matrix, target, t, midRow - 1, midCol, r) ||
                    dfs(matrix, target, midRow, b, l, midCol - 1);
        }
    }
}
