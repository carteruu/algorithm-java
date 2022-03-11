package com.carter.off;

public class Item29 {
//    public int[] spiralOrder(int[][] matrix) {
//        if (matrix.length == 0 || matrix[0].length == 0) {
//            return new int[]{};
//        }
//        int n = matrix.length;
//        int m = matrix[0].length;
//
//        int top = 0;
//        int bottom = n - 1;
//        int left = 0;
//        int right = m - 1;
//
//        int colIdx = 0;
//        int rowIdx = 0;
//
//        int idx = 0;
//        int[] res = new int[n * m];
//        while (idx < res.length) {
//            while (colIdx <= right) {
//                res[idx] = matrix[rowIdx][colIdx];
//                colIdx++;
//                idx++;
//            }
//            colIdx--;
//            top++;
//            rowIdx = top;
//            while (rowIdx <= bottom) {
//                res[idx] = matrix[rowIdx][colIdx];
//                rowIdx++;
//                idx++;
//            }
//            rowIdx--;
//            right--;
//            colIdx = right;
//            while (colIdx >= left) {
//                res[idx] = matrix[rowIdx][colIdx];
//                colIdx--;
//                idx++;
//            }
//            colIdx++;
//            bottom--;
//            rowIdx = bottom;
//            while (rowIdx >= top) {
//                res[idx] = matrix[rowIdx][colIdx];
//                rowIdx--;
//                idx++;
//            }
//            rowIdx++;
//            left++;
//            colIdx = left;
//        }
//        return res;
//    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;

        int colStep = 1;
        int rowStep = 0;

        int colIdx = 0;
        int rowIdx = 0;

        int[] res = new int[n * m];
        for (int i = 0; i < n * m; i++) {
            res[i] = matrix[rowIdx][colIdx];
            if (colStep == 1 && colIdx == right && rowIdx == top) {
                //向右,遍历到右上角
                //方向改为向下
                colStep = 0;
                rowStep = 1;
                //第一行遍历完了,top向下移动
                top++;
            }
            if (rowStep == 1 && rowIdx == bottom && colIdx == right) {
                //向下,遍历到右下角
                //方向改为向左
                colStep = -1;
                rowStep = 0;
                //最后一列遍历完了,right向左移动
                right--;
            }
            if (colStep == -1 && colIdx == left && rowIdx == bottom) {
                //向左,遍历到左下角
                //方向改为向上
                colStep = 0;
                rowStep = -1;
                //最后一行遍历完了,bottom向上移动
                bottom--;
            }
            if (rowStep == -1 && rowIdx == top && colIdx == left) {
                //向上,遍历到左上角
                //方向改为向右
                colStep = 1;
                rowStep = 0;
                //第一列遍历完了,left向右移动
                left++;
            }
            colIdx += colStep;
            rowIdx += rowStep;
        }
        return res;
    }
}
