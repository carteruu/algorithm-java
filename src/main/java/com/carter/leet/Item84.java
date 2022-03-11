package com.carter.leet;

public class Item84 {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int area = heights[0];
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                if (heights[j] < min) {
                    min = heights[j];
                    if (min * (heights.length - i) < area) {
                        //面积最大值小于面积,后面的不用遍历了
                        break;
                    }
                }
                area = Math.max(area, min * (j - i + 1));
            }
        }
        return area;
    }
}
