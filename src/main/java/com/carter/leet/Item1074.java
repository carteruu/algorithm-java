package com.carter.leet;

import java.util.HashMap;
import java.util.Map;

public class Item1074 {


    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int lenX = matrix.length;
        int lenY = matrix[0].length;
        int count = 0;
        for (int i = 0; i < lenX; i++) {
            int[] sum = new int[lenY];
            for (int j = i; j < lenX; j++) {
                for (int k = 0; k < lenY; k++) {
                    sum[k] += matrix[j][k];
                }

                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for (int k = 0; k < lenY; k++) {
                    count += map.get(sum[k] - target);
                    map.put(sum[k], map.getOrDefault(sum[k], 0) + 1);
                }
            }
        }
        return count;
    }

    public int numSubmatrixSumTarget1(int[][] matrix, int target) {
        int lenX = matrix.length;
        int lenY = matrix[0].length;
        int[][][] arr = new int[lenX][lenY][lenY];
        int count = 0;
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                arr[i][j][j] = matrix[i][j];
                for (int k = j + 1; k < lenY; k++) {
                    arr[i][j][k] = arr[i][j][k - 1] + matrix[i][k];
                }
            }
        }

        int val = 0;
        for (int i = 0; i < lenY; i++) {
            for (int j = i; j < lenY; j++) {
                for (int k = 0; k < lenX; k++) {
                    val = arr[k][i][j];
                    if (val == target) {
                        count++;
                    }
                    for (int l = k + 1; l < lenX; l++) {
                        val = val + arr[l][i][j];
                        if (val == target) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
