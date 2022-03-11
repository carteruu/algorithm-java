package com.carter.leet;

import java.util.Arrays;

public class Item1738 {
    public static void main(String[] args) {
        int[][] matrix = {{10, 9, 5}, {2, 0, 4}, {1, 0, 9}, {3, 4, 8}};
//        int[][] matrix = {{5, 2}, {1, 6}};
        System.out.println(new Item1738().kthLargestValue(matrix, 2));
    }


    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        result[0] = matrix[0][0];
        //第一行
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] ^ matrix[0][i];
        }
        //第一列
        for (int i = 1; i < m; i++) {
            result[i * n] = result[(i - 1) * n] ^ matrix[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i * n + j] = matrix[i][j] ^ result[(i - 1) * n + j] ^ result[i * n + j - 1] ^ result[(i - 1) * n + j - 1];
            }
        }

        Arrays.sort(result);
        return result[m * n - k];
    }
}
