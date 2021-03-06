package com.carter.offer;

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
                //??????,??????????????????
                //??????????????????
                colStep = 0;
                rowStep = 1;
                //?????????????????????,top????????????
                top++;
            }
            if (rowStep == 1 && rowIdx == bottom && colIdx == right) {
                //??????,??????????????????
                //??????????????????
                colStep = -1;
                rowStep = 0;
                //????????????????????????,right????????????
                right--;
            }
            if (colStep == -1 && colIdx == left && rowIdx == bottom) {
                //??????,??????????????????
                //??????????????????
                colStep = 0;
                rowStep = -1;
                //????????????????????????,bottom????????????
                bottom--;
            }
            if (rowStep == -1 && rowIdx == top && colIdx == left) {
                //??????,??????????????????
                //??????????????????
                colStep = 1;
                rowStep = 0;
                //?????????????????????,left????????????
                left++;
            }
            colIdx += colStep;
            rowIdx += rowStep;
        }
        return res;
    }
}
