package com.carter.leet;

public class Item275 {
    public int hIndex(int[] citations) {
        int h = 0;

        int start = 0;
        int end = citations.length - 1;
        while (start <= end) {
            int mid = ((end - start) >> 1) + start;
            int len = citations.length - mid;
            h = Math.max(h, len);
            if (citations[mid] > len) {
                //往左
                end = mid - 1;
            } else if (citations[mid] < len) {
                //往右
                start = mid + 1;
            } else {
                break;
            }
        }

        return h;
    }
}
