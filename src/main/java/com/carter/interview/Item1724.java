package com.carter.interview;

public class Item1724 {
    class Solution {
        public int[] getMaxMatrix(int[][] matrix) {
            int n = matrix.length, m = matrix[0].length;
            //二维前缀和
            int[][] preSum = new int[n + 1][m + 1];
            for(int i = 1; i < n + 1; i ++) {
                for(int j = 1; j < m + 1; j ++) {
                    preSum[i][j] = matrix[i - 1][j - 1] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
                }
            }
            //开始最大子序和
            int gobalMax = Integer.MIN_VALUE;
            int[] ret = new int[4];
            //先固定上下两条边
            for(int top = 0; top < n; top ++) {
                for(int bottom = top; bottom < n; bottom ++) {
                    int localMax, left = 0;
                    //然后从左往右一遍扫描找最大子序和
                    for(int right = 0; right < m; right ++) {
                        //利用presum快速求出localMax
                        localMax = preSum[bottom + 1][right + 1] + preSum[top][left] - preSum[bottom + 1][left] - preSum[top][right + 1];
                        //如果比gobal大，更新
                        if(gobalMax < localMax) {
                            gobalMax = localMax;
                            ret[0] = top;
                            ret[1] = left;
                            ret[2] = bottom;
                            ret[3] = right;
                        }
                        //如果不满0，前面都舍弃，从新开始计算，left更新到right+1，right下一轮递增之后left==right
                        if(localMax < 0) {
                            localMax = 0;
                            left = right + 1;
                        }
                    }
                }
            }
            return ret;
        }
    }
}
