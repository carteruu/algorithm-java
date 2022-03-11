package com.carter.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Item4 {
    public double findMedianSortedArrays4(int[] nums1, int[] nums2) {
        return 0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) {
            return findMedian(nums2);
        }
        if (n == 0) {
            return findMedian(nums1);
        }

        int p1 = m / 2;
        int p2 = n / 2;

        int left1 = 0;
        int left2 = 0;
        int right1 = m;
        int right2 = n;


        while (left1 < right1 && left2 < right2) {
            if (nums1[p1] == nums2[p2]) {
                return nums1[p1];
            } else if (nums1[p1] < nums2[p2]) {
                left1 = p1;
                right2 = p2;
            } else {
                right1 = p1;
                left2 = p2;
            }
            p1 = (right1 - left1) / 2;
            p2 = (right2 - left1) / 2;
        }
        return 0;
    }

    private double findMedian(int[] nums) {
        int p = nums.length / 2;
        if (nums.length % 2 == 0) {
            //偶数个元素
            return (nums[p - 1] + nums[p]) / 2.0;
        } else {
            return nums[p];
        }
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2] + nums2[n / 2]) / 2.0;
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2] + nums1[m / 2]) / 2.0;
            }
        }

        int l1 = 0;
        int r1 = m - 1;
        int l2 = 0;
        int r2 = n - 1;

        int count = m + n;
        boolean isEven = count % 2 == 0;
        if (isEven) {
            count = count / 2 - 1;
        } else {
            count = count / 2;
        }
        for (int i = 0; i < count; i++) {
            if (nums1[l1] <= nums2[l2] || l2 > r2) {
                l1++;
            } else {
                l2++;
            }
            if (nums1[r1] >= nums2[r2] || r2 > l2) {
                r1--;
            } else {
                r2--;
            }
        }
        if (isEven) {
            if (l1 < r1) {
                return (nums1[l1] + nums1[r1]) / 2.0;
            } else if (l1 > r1) {
                return (nums2[l2] + nums1[r2]) / 2.0;
            } else {
                return (nums1[l1] + nums2[l1]) / 2.0;
            }
        } else {
            if (l1 == r1) {
                return nums1[l1];
            } else {
                return nums2[l2];
            }
        }
    }
}
