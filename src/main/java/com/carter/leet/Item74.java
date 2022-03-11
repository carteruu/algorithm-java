package com.carter.leet;

public class Item74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int r = n * m - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            int midVal = matrix[mid / m][mid % m];
            if (midVal > target) {
                r = mid - 1;
            } else if (midVal < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
