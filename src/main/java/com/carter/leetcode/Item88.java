package com.carter.leetcode;

public class Item88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = n, p2 = 0;
        int pr = 0;
        System.arraycopy(nums1, 0, nums1, n, m);
        while (p1 < m + n || p2 < n) {
            if (p2 == n || (p1 < m + n && nums1[p1] <= nums2[p2])) {
                nums1[pr] = nums1[p1];
                p1++;
            } else {
                nums1[pr] = nums2[p2];
                p2++;
            }
            pr++;
        }
    }
}
