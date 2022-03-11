package com.carter.leet;

import java.util.Arrays;

public class Item1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = 1000000007;
        int n = nums1.length;
        int[] sort = Arrays.copyOf(nums1, n);
        Arrays.sort(sort);
        int rs = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            int abs = Math.abs(nums1[i] - nums2[i]);
            rs = (rs + abs) % mod;
            //找出最接近nums2[i]的nums1元素
            int left = 0;
            int right = n - 1;
            int mid;
            while (left < right) {
                mid = ((right - left + 1) >> 1) + left;
                if (sort[mid] > nums2[i]) {
                    right = mid - 1;
                } else if (sort[mid] < nums2[i]) {
                    left = mid;
                } else {
                    left = mid;
                    break;
                }
            }

            if (left < n) {
                temp = Math.max(temp, abs - Math.abs(sort[left] - nums2[i]));
            }
            if (left + 1 < n) {
                temp = Math.max(temp, abs - Math.abs(sort[left + 1] - nums2[i]));
            }
        }
        return (rs - temp + mod) % mod;
    }

    public int minAbsoluteSumDiff2(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;
        int n = nums1.length;
        int[] rec = new int[n];
        System.arraycopy(nums1, 0, rec, 0, n);
        Arrays.sort(rec);
        int sum = 0, maxn = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MOD;
            int j = binarySearch(rec, nums2[i]);
            if (j < n) {
                maxn = Math.max(maxn, diff - (rec[j] - nums2[i]));
            }
            if (j > 0) {
                maxn = Math.max(maxn, diff - (nums2[i] - rec[j - 1]));
            }
        }
        return (sum - maxn + MOD) % MOD;
    }

    public int binarySearch(int[] rec, int target) {
        int low = 0, high = rec.length - 1;
        if (rec[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (rec[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int minAbsoluteSumDiff1(int[] nums1, int[] nums2) {
        int rs = 0;
        for (int k = 0; k < nums1.length; k++) {
            rs += Math.abs(nums1[k] - nums2[k]) % 10000007;
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                int temp = nums1[j];
                nums1[j] = nums1[i];
                int tempRs = 0;
                for (int k = 0; k < nums1.length; k++) {
                    tempRs += Math.abs(nums1[k] - nums2[k]) % 10000007;
                }
                rs = Math.min(rs, tempRs);
                //还原
                nums1[j] = temp;
            }
        }
        return rs;
    }
}
