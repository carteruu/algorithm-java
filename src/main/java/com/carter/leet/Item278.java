package com.carter.leet;

public class Item278 {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid;
        int res = 0;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (isBadVersion(mid)) {
                //错误的版本,往左
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    private boolean isBadVersion(int version) {
        return version == 4;
    }
}
